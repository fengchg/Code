package com.maro.client.module.serverorder.service.impl;

import com.maro.client.common.constant.enumconstant.CommonTypeEnum;
import com.maro.client.common.constant.enumconstant.ServerOrderLogTypeEnum;
import com.maro.client.common.dao.ClientCommonDao;
import com.maro.client.common.util.PojoUtil;
import com.maro.client.module.serverorder.pojo.dto.MaroClientServerorderDTO;
import com.maro.client.module.serverorder.pojo.dto.SeatchangeParamsDTO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientSeatchangeDO;
import com.maro.client.module.serverorder.pojo.entity.MaroClientServerorderDO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientSeatchangeVO;
import com.maro.client.module.serverorder.pojo.vo.MaroClientServerorderVO;
import com.maro.client.module.serverorder.service.MaroClientSeatchangeService;
import com.maro.common.shop.pojo.entity.MaroShopSeatEntity;
import com.maro.platform.core.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.*;

/**
 * 桌位变更记录服务实现
 * @author 冯成果
 * @date 2018-3-26
 * @since 01.00.0001
*/
@Service
public class MaroClientSeatchangeServiceImpl implements MaroClientSeatchangeService {

    String LISTUSEDSEATCHANGEDO_HQL = " from MaroClientSeatchangeDO seat where seat.serverOrderId = ? and seat.deleteFlag = ? order by happenTime desc";
    String groupName = "并";

    final String SQL_UPDATE_CHANGESEAT = "update maro_client_seatchange set delete_flag = ? where server_order_id = ? and dest_seat_id = ?";
    @Resource
    private ClientCommonDao dao;


    @Override
    public Boolean saveSeatchangeDO(MaroClientSeatchangeDO maroClientSeatchangeDO) {

        dao.save(maroClientSeatchangeDO);
        return null;
    }

    @Override
    public List<MaroClientSeatchangeDO> listSeatchangeDO(MaroClientServerorderDTO maroClientServerorderDTO) {
        return null;
    }

    @Override
    public MaroClientSeatchangeDO getSeatchangeDObyId(String id) {
        return dao.get(MaroClientSeatchangeDO.class,id);
    }

    @Override
    public List<MaroClientSeatchangeDO> listSeatchangeDOByServerOrderId(String serverOrderId) {
        return dao.list(" from MaroClientSeatchangeDO where serverOrderId=? and deleteFlag = ?",serverOrderId,CommonTypeEnum.DELETE_FLAG_NO.getCode());
    }

    @Override
    public List<MaroClientSeatchangeVO> listUsedSeatchangeDO(List<MaroClientServerorderDO> serverOrderDOList) {
        int groupCode = 1;
        boolean hasGroup = false;
        Map<String,Object> map = new HashMap<String,Object>();
        List<MaroClientSeatchangeVO> maroClientSeatchangeDOList = new ArrayList<MaroClientSeatchangeVO>();
        List<MaroClientServerorderVO> maroClientServerorderVOList = PojoUtil.convertBatchDO2VO(serverOrderDOList, MaroClientServerorderVO.class);

        for(int i=0;i<maroClientServerorderVOList.size();i++){
            MaroClientServerorderVO maroClientServerorderVO = maroClientServerorderVOList.get(i);

            List<MaroClientSeatchangeDO> list = dao.list(LISTUSEDSEATCHANGEDO_HQL, maroClientServerorderVO.getId(), CommonTypeEnum.DELETE_FLAG_NO.getCode());

            for(int j=0;j<list.size();j++){
                MaroClientSeatchangeDO maroClientSeatchangeDO = list.get(j);
                MaroClientSeatchangeVO maroClientSeatchangeVO = PojoUtil.convertDO2VO(maroClientSeatchangeDO, MaroClientSeatchangeVO.class);
                maroClientSeatchangeVO.setMaroClientServerorderVO(maroClientServerorderVO);
                String destSeatId = maroClientSeatchangeVO.getDestSeatId();
                String srcSeatId = maroClientSeatchangeVO.getSrcSeatId();
                if(ServerOrderLogTypeEnum.MERGE_SEAT.getCode().equals(maroClientSeatchangeVO.getType())){//如果有并桌的情况

                    boolean groupLead = destSeatId.equals(srcSeatId);
                    maroClientSeatchangeVO.setGroupLead(groupLead);
                    maroClientSeatchangeVO.setGroup(groupCode);
                    maroClientSeatchangeVO.setGroupString(groupName+groupCode);
                    hasGroup = true;
                }
                if(map.get(destSeatId) == null) {
                    maroClientSeatchangeDOList.add(maroClientSeatchangeVO);
                    map.put(destSeatId,destSeatId);
                }
            }

            if(hasGroup){
                groupCode++;
                hasGroup=false;
            }

        }

        return maroClientSeatchangeDOList;
    }

    @Override
    public void changeSeat(SeatchangeParamsDTO seatchangeParamsDTO) {

        MaroClientServerorderDO maroClientServerorderDO = seatchangeParamsDTO.getMaroClientServerorderDO();
        String serverorderId = maroClientServerorderDO.getId();
        String srcSeatId = seatchangeParamsDTO.getSrcMaroShopSeatEntity().getId();

//        String sql = "update maro_client_seatchange set delete_flag = ? where server_order_id = ? and dest_seat_id = ?";

        dao.executeUpdateSql(SQL_UPDATE_CHANGESEAT,CommonTypeEnum.DELETE_FLAG_YES.getCode(),serverorderId,srcSeatId);



        MaroShopSeatEntity destMaroShopSeatEntity = seatchangeParamsDTO.getDestMaroShopSeatEntity();
        changeSeat(maroClientServerorderDO,destMaroShopSeatEntity);
        open(maroClientServerorderDO,destMaroShopSeatEntity);
    }

    @Override
    public void open(MaroClientServerorderDO maroClientServerorderDO,MaroShopSeatEntity maroShopSeatEntity){
        MaroClientSeatchangeDO maroClientSeatchangeDO = createDO(maroClientServerorderDO,maroShopSeatEntity,maroShopSeatEntity,ServerOrderLogTypeEnum.OPEN.getCode(),ServerOrderLogTypeEnum.OPEN.getName());
        saveSeatchangeDO(maroClientSeatchangeDO);
    }
    private void changeSeat(MaroClientServerorderDO maroClientServerorderDO,MaroShopSeatEntity maroShopSeatEntity){
        MaroClientSeatchangeDO maroClientSeatchangeDO = createDO(maroClientServerorderDO,maroShopSeatEntity,maroShopSeatEntity,ServerOrderLogTypeEnum.CHANGE_SEAT.getCode(),ServerOrderLogTypeEnum.CHANGE_SEAT.getName());
        saveSeatchangeDO(maroClientSeatchangeDO);
    }

    @Override
    public void mergeListSeat(List<SeatchangeParamsDTO> seatchangeParamsDTOList) {
        SeatchangeParamsDTO leadSeatchangeParamsDTO = seatchangeParamsDTOList.get(0);
        MaroClientServerorderDO maroClientServerorderDO = leadSeatchangeParamsDTO.getMaroClientServerorderDO();
        MaroShopSeatEntity leadMergeMaroShopSeatEntity = leadSeatchangeParamsDTO.getMergeMaroShopSeatEntity();
        mergeSeat(maroClientServerorderDO,leadMergeMaroShopSeatEntity,leadMergeMaroShopSeatEntity);
        for(int i=1;i<seatchangeParamsDTOList.size();i++){
            SeatchangeParamsDTO seatchangeParamsDTO = seatchangeParamsDTOList.get(i);
            MaroShopSeatEntity mergeMaroShopSeatEntity = seatchangeParamsDTO.getMergeMaroShopSeatEntity();
            mergeSeat(maroClientServerorderDO,mergeMaroShopSeatEntity,leadMergeMaroShopSeatEntity);
            if(seatchangeParamsDTO.getMaroClientServerorderDO() != null && !StringUtil.isEmpty(seatchangeParamsDTO.getMaroClientServerorderDO().getId())) {
                String sql = "update maro_client_seatchange set delete_flag = ? where server_order_id = ?";
                dao.executeUpdateSql(sql, CommonTypeEnum.DELETE_FLAG_YES.getCode(), seatchangeParamsDTO.getCancelMergeMaroClientServerorderDO().getId());
            }
        }
    }

    @Override
    public void cancelMergeSeat(SeatchangeParamsDTO seatchangeParamsDTO) {
        String serverorderId = seatchangeParamsDTO.getMaroClientServerorderDO().getId();
        String seatId = seatchangeParamsDTO.getMergeMaroShopSeatEntity().getId();

        String sql1 = "select count(id) from maro_client_seatchange where delete_flag = ? and server_order_id = ? and type = ?";
        BigInteger count = (BigInteger) dao.getObjectBySql(sql1, CommonTypeEnum.DELETE_FLAG_NO.getCode(), serverorderId, ServerOrderLogTypeEnum.MERGE_SEAT.getCode());

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa:"+count.intValue());

        if(count.intValue() <= 2) {

            String sql = "update maro_client_seatchange set delete_flag = ? where server_order_id = ? and type = ?";
            dao.executeUpdateSql(sql, CommonTypeEnum.DELETE_FLAG_YES.getCode(), serverorderId,ServerOrderLogTypeEnum.MERGE_SEAT.getCode());

            System.out.println("剩余"+count.intValue()+"更改全部");
        }else{

            String sql = "update maro_client_seatchange set delete_flag = ? where server_order_id = ? and dest_seat_id = ?";
            dao.executeUpdateSql(sql, CommonTypeEnum.DELETE_FLAG_YES.getCode(), serverorderId, seatId);
            System.out.println("剩余"+count.intValue()+"更改一条");
        }



        open(seatchangeParamsDTO.getCancelMergeMaroClientServerorderDO(),seatchangeParamsDTO.getMergeMaroShopSeatEntity());


    }

    private void mergeSeat(MaroClientServerorderDO maroClientServerorderDO,MaroShopSeatEntity destMaroShopSeatEntity,MaroShopSeatEntity srcMaroShopSeatEntity){
        MaroClientSeatchangeDO maroClientSeatchangeDO = createDO(maroClientServerorderDO, destMaroShopSeatEntity,srcMaroShopSeatEntity, ServerOrderLogTypeEnum.MERGE_SEAT.getCode(), ServerOrderLogTypeEnum.MERGE_SEAT.getName());
        saveSeatchangeDO(maroClientSeatchangeDO);
    }


    private MaroClientSeatchangeDO createDO(MaroClientServerorderDO maroClientServerorderDO,MaroShopSeatEntity destMaroShopSeatEntity,MaroShopSeatEntity srcMaroShopSeatEntity,Integer type,String name){
        MaroClientSeatchangeDO maroClientSeatchangeDO = new MaroClientSeatchangeDO();
        maroClientSeatchangeDO.setId(UUID.randomUUID().toString());
        maroClientSeatchangeDO.setSrcSeatId(srcMaroShopSeatEntity.getId());
        maroClientSeatchangeDO.setSrcSeatCode(srcMaroShopSeatEntity.getId());
        maroClientSeatchangeDO.setSrcSeatName(srcMaroShopSeatEntity.getName());
        maroClientSeatchangeDO.setDestSeatCode(destMaroShopSeatEntity.getId());
        maroClientSeatchangeDO.setDestSeatId(destMaroShopSeatEntity.getId());
        maroClientSeatchangeDO.setDestSeatName(destMaroShopSeatEntity.getName());
        maroClientSeatchangeDO.setServerOrderId(maroClientServerorderDO.getId());
        maroClientSeatchangeDO.setHappenTime(System.currentTimeMillis());
        maroClientSeatchangeDO.setName(name);
        maroClientSeatchangeDO.setType(type);
        maroClientSeatchangeDO.setDeleteFlag(CommonTypeEnum.DELETE_FLAG_NO.getCode());
        return maroClientSeatchangeDO;
    }

    @Override
    public boolean isSeatMerged(String seatId, String serverorderId){
        final String SQL_GET_ISSEATMERGED = "select count(id) from maro_client_seatchange where delete_flag = ? and server_order_id = ? and dest_seat_id = ? and type = ?";
        BigInteger count = (BigInteger) dao.getObjectBySql(SQL_GET_ISSEATMERGED, CommonTypeEnum.DELETE_FLAG_NO.getCode(), serverorderId, seatId, ServerOrderLogTypeEnum.MERGE_SEAT.getCode());
        if(count.intValue() > 0){
            return true;
        }else {
            return false;
        }
    }

}
