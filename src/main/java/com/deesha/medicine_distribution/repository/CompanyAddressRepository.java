package com.deesha.medicine_distribution.repository;

import com.deesha.medicine_distribution.model.CompanyAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyAddressRepository extends JpaRepository<CompanyAddress,Long> {

    @Query("""
            select a from CompanyAddress a
            join fetch a.city c
            join fetch c.district d
            join fetch d.state s
            join fetch s.country
            where a.company.companyId = :companyId
            order by a.addressType
            """)
    List<CompanyAddress> findAllByCompany(@Param("companyId") Integer companyId);

    @Query("""
            select a from CompanyAddress a
            join fetch a.city c
            join fetch c.district d
            join fetch d.state s
            join fetch s.country
            where a.company.companyId = :companyId and a.addressId = :addressId
            """)
    Optional<CompanyAddress> findByCompanyAndId(@Param("companyId") Integer companyId,
                                                @Param("addressId") Long addressId);

    boolean existsByCompanyCompanyIdAndAddressType(Integer companyId, CompanyAddress.AddressType type);


}