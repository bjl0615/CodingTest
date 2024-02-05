package com.rmsoft.codingtest.service;

import com.rmsoft.codingtest.mapper.SubscriptionMapper;
import com.rmsoft.codingtest.model.SubType;
import com.rmsoft.codingtest.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubService {

    private final SubscriptionMapper subscriptionMapper;

    @Autowired
    public SubService(SubscriptionMapper subscriptionMapper) {
        this.subscriptionMapper = subscriptionMapper;
    }

    @Transactional
    public void create(Subscription subscription) {
        System.out.println(subscription.getServiceType().equals(SubType.Premium));
        if(subscription.getServiceType().equals(SubType.Basic)) {
            subscription.setServiceType(SubType.Basic);
            subscription.setStorageCapacity(1048576.0);
            subscription.setRemainStorageCapacity(1048576.0);
        } else if (subscription.getServiceType().equals(SubType.Standard)) {
            subscription.setServiceType(SubType.Standard);
            subscription.setStorageCapacity(2097152.0);
            subscription.setRemainStorageCapacity(2097152.0);
        }else if (subscription.getServiceType().equals(SubType.Premium)){
            subscription.setServiceType(SubType.Premium);
            subscription.setStorageCapacity(3145728.0);
            subscription.setRemainStorageCapacity(3145728.0);
        }

        subscriptionMapper.save(subscription);
    }

    @Transactional
    public List<Subscription> getAllUser() {
        return subscriptionMapper.findAll();
    }

    @Transactional
    public Subscription getSubscriptionByUsername(String subscription) {
        return subscriptionMapper.findByUsername(subscription);
    }

    @Transactional
    public void modify(Subscription subscription) {
        Subscription sub = subscriptionMapper.findByUsername(subscription.getUsername());
        int extension = subscription.getSubscriptionPeriod() + sub.getSubscriptionPeriod();
        double remain = 0.0;
        sub.setSubscriptionPeriod(extension);
        if(subscription.getServiceType().equals(SubType.Basic)) {
            sub.setServiceType(SubType.Basic);
            sub.setStorageCapacity(1048576.0);
        } else if(subscription.getServiceType().equals(SubType.Standard)) {
            sub.setServiceType(SubType.Standard);
            sub.setStorageCapacity(2097152.0);
        } else if(subscription.getServiceType().equals(SubType.Premium)) {
            sub.setServiceType(SubType.Premium);
            sub.setStorageCapacity(3145728.0);
        }
        remain = sub.getStorageCapacity() - sub.getUseStorageCapacity();
        sub.setRemainStorageCapacity(remain);
        subscriptionMapper.update(sub);
    }

    @Transactional
    public void useStorage(Subscription subscription) {
        Subscription sub = subscriptionMapper.findByUsername(subscription.getUsername());
        double remain = sub.getRemainStorageCapacity() - subscription.getUseStorageCapacity();
        double use = sub.getUseStorageCapacity() + subscription.getUseStorageCapacity();

        if(remain <= 0) {
            sub.setUseStorageCapacity(0);
            sub.setRemainStorageCapacity(0);
        } else {
            sub.setUseStorageCapacity(use);
            sub.setRemainStorageCapacity(remain);
        }

        subscriptionMapper.useStorage(sub);

    }
}
