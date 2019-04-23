
package com.smzc.job.service;

import com.smzc.common.objects.expt.RollbackException;
import com.smzc.domain.ConsumerCardInfo;

/**
* 消费卡卡信息，初始化后只可改状态 <br />
* <B>Copyright</B> Copyright (c) 2019 com.smzc All rights reserved. <br />
* <B>CreateTime</B> 2019/03/12 11:44:10
* @author yjj
*/
public interface ConsumerCardInfoManager {



    ConsumerCardInfo getById(Long id) throws RollbackException;



}
