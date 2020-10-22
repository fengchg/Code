package com.maro.client.module.queue.service.impl;

import com.maro.client.common.constant.StringConstant;
import com.maro.client.module.queue.pojo.vo.QueueItemVO;
import com.maro.client.module.queue.service.QueueService;
import com.maro.platform.core.common.model.json.AjaxJson;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueServiceImpl implements QueueService {

    final static String CALLNUM_NOW = "当前没有排队，可以立即上桌！";
    /**
     * 先进先出队列，线程安全
     */
    private Map<Integer,LinkedBlockingQueue<QueueItemVO>> queueMap = new Hashtable<Integer,LinkedBlockingQueue<QueueItemVO>>();

    @Override
    public AjaxJson queue(Integer seatGroupType,Integer seatType,String phone) {
        AjaxJson ajaxJson = new AjaxJson();
        LinkedBlockingQueue linkedBlockingQueue = queueMap.get(seatType);
        if(linkedBlockingQueue == null){
            linkedBlockingQueue = new LinkedBlockingQueue<QueueItemVO>();
            queueMap.put(seatGroupType+seatType,linkedBlockingQueue);
        }
        int num = linkedBlockingQueue.size()+1;
        QueueItemVO queueItemVO = new QueueItemVO();
        queueItemVO.setCreateTime(System.currentTimeMillis());
        queueItemVO.setPhone(phone);
        queueItemVO.setSeatGroupType(seatGroupType);
        queueItemVO.setSeatType(seatType);
        queueItemVO.setNum(num);
        linkedBlockingQueue.add(queueItemVO);
        ajaxJson.setSuccess(true);
        ajaxJson.setObj(queueItemVO);
        ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
        return ajaxJson;
    }

    @Override
    public AjaxJson callNum(Integer seatGroupType,Integer seatType) {
        AjaxJson ajaxJson = new AjaxJson();
        LinkedBlockingQueue<QueueItemVO> queue = queueMap.get(seatGroupType + seatType);
        QueueItemVO queueItemVO = null;
        if(queue == null){
            ajaxJson.setMsg(CALLNUM_NOW);
            ajaxJson.setSuccess(false);
        }else {
            queueItemVO = queue.poll();
            ajaxJson.setMsg(StringConstant.TIP_SUCCESS);
            ajaxJson.setSuccess(true);
            ajaxJson.setObj(queueItemVO);
        }
        return ajaxJson;
    }
}
