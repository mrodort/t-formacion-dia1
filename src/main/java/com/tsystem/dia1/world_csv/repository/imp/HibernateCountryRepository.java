package com.tsystem.dia1.world_csv.repository.imp;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.tsystem.dia1.world_csv.configuration.HibernateUtil;
import com.tsystem.dia1.world_csv.domain.CountryEntity;
import com.tsystem.dia1.world_csv.error.RepositoryConnectionExpection;
import com.tsystem.dia1.world_csv.repository.CountryRepository;

public class HibernateCountryRepository implements CountryRepository {

    @SuppressWarnings("unchecked")
    @Override
    public List<CountryEntity> findByNameStartWith(String startWith) throws RepositoryConnectionExpection {

	@SuppressWarnings("deprecation")
	Criteria nameStartWithCriteria = HibernateUtil.getSession().createCriteria(CountryEntity.class);
	nameStartWithCriteria.add(Restrictions.ilike("name", startWith, MatchMode.START));

	return nameStartWithCriteria.list();
    }

    @Override
    public Optional<CountryEntity> findByCode(String code) throws RepositoryConnectionExpection {

	Query createQuery = HibernateUtil.getSession().createQuery("FROM CountryEntity WHERE code= :mycode");
	createQuery.setParameter("mycode", code);

	CountryEntity uniqueResult = (CountryEntity) createQuery.uniqueResult();

	return Optional.ofNullable(uniqueResult);
    }

}
