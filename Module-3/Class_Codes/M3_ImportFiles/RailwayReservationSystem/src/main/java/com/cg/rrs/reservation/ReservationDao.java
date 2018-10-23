package com.cg.rrs.reservation;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.rrs.entity.ReservationDetails;


public interface ReservationDao extends MongoRepository<ReservationDetails,String>
{

}
