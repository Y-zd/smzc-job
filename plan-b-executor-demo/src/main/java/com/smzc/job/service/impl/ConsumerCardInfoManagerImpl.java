
package com.smzc.job.service.impl;

import com.smzc.common.objects.expt.RollbackException;
import com.smzc.domain.ConsumerCardInfo;
import com.smzc.job.service.ConsumerCardInfoManager;
import com.smzc.provider.persistence.ConsumerCardInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* 消费卡卡信息，初始化后只可改状态 <br />
* <B>Copyright</B> Copyright (c) 2019 com.smzc All rights reserved. <br />
* <B>CreateTime</B> 2019/03/12 11:44:10
* @author yjj
*/
@Component
public class ConsumerCardInfoManagerImpl implements ConsumerCardInfoManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private ConsumerCardInfoDao consumerCardInfoDao;

    @Override
    public ConsumerCardInfo getById(Long id) throws RollbackException {
        return consumerCardInfoDao.getById(id);
    }


}
