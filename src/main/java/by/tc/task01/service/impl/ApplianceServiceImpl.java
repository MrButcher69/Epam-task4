package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.CriteriaValidator;
import by.tc.task01.service.validation.Validator;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApplianceServiceImpl implements ApplianceService{

	final private Validator validator = new CriteriaValidator();

	@Override
	public Appliance find(Criteria criteria) throws IOException, URISyntaxException {
		if (!(validator.validatorOfCriteria(criteria))) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		Appliance appliance = applianceDAO.find(criteria);

		return appliance;
	}
}

