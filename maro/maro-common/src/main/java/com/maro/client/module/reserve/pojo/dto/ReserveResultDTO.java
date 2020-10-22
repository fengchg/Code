package com.maro.client.module.reserve.pojo.dto;

import com.maro.client.module.reserve.pojo.vo.MaroClientReserveSeatVO;
import com.maro.client.module.reserve.pojo.vo.MaroClientReserveVO;

import java.util.List;

/**
 * 预定传输结果
 * @author 冯成果
 * @date 2018-4-14
 * @since 版本号（必填）
*/
public class ReserveResultDTO {

    private MaroClientReserveVO maroClientReserveVO;
    private MaroClientReserveSeatVO maroClientReserveSeatVO;

    private List<MaroClientReserveVO> maroClientReserveVOList;

    public List<MaroClientReserveVO> getMaroClientReserveVOList() {
        return maroClientReserveVOList;
    }

    public void setMaroClientReserveVOList(List<MaroClientReserveVO> maroClientReserveVOList) {
        this.maroClientReserveVOList = maroClientReserveVOList;
    }

    public MaroClientReserveVO getMaroClientReserveVO() {
        return maroClientReserveVO;
    }

    public void setMaroClientReserveVO(MaroClientReserveVO maroClientReserveVO) {
        this.maroClientReserveVO = maroClientReserveVO;
    }

    public MaroClientReserveSeatVO getMaroClientReserveSeatVO() {
        return maroClientReserveSeatVO;
    }

    public void setMaroClientReserveSeatVO(MaroClientReserveSeatVO maroClientReserveSeatVO) {
        this.maroClientReserveSeatVO = maroClientReserveSeatVO;
    }
}
