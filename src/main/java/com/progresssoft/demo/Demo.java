package com.progresssoft.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.logging.Logger;
import java.util.Date;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;

import com.progresssoft.config.HibUtil;
import com.progresssoft.controller.RequestValidation;
import com.progresssoft.dao.DealDAOImpl;
import com.progresssoft.model.InvalidDeal;
import com.progresssoft.model.ValidDeal;
/**
 * In this Demo I'm trying to read deals data from random CSV file in my computer
 * @author Naseem Adel 
 *
 */
public class Demo {

	static Logger logger = Logger.getLogger(Demo.class.getName());
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		boolean isVaildDeal = true;
		HashSet<Integer> dealsId = new HashSet<Integer>();
		String classesFile = "data.csv";

		CSVParser parser = null;
		parser = new CSVParser(new FileReader(classesFile), CSVFormat.DEFAULT.withHeader());

		ValidDeal validDeal = new ValidDeal();
		InvalidDeal invalidDeal = new InvalidDeal();
		RequestValidation obj = new RequestValidation();

		for (CSVRecord record : parser) {

			// Check Deal ID to gurantee the customer if he request the same offer again
			if (record.get("id").trim().equals("")) {
				logger.info("ID field is Missing !! ");
				isVaildDeal =false;
				invalidDeal.setId("");
			} else {
				if (dealsId.contains((Integer.valueOf(record.get("id").trim())))) {
					System.out.println("This deal is already exist, you can't add this deal again!!");
					invalidDeal.setId("");
				} else
					validDeal.setId(Integer.valueOf(record.get("id").trim()));
			}
			// Chcek FromCurrency
			if (record.get("fromCurrency").trim().equals("")) {
				logger.info("Fromcurrency field is Missing !! ");
				isVaildDeal =false;
			} else {
				if (obj.checkCurrency(record.get("fromCurrency").trim())) {
					validDeal.setFromCurrency(record.get("fromCurrency").trim());
				}

				else {
					System.out.println("Inavlid currency ISO Code");
					invalidDeal.setFromCurrency("");
				}
			}
			// Chcek ToCurrency
			if (record.get("toCurrency").trim().equals("")) {
				logger.info("ToCurrency field is Missing !! ");
				isVaildDeal =false;
			} else {
				if (obj.checkCurrency(record.get("toCurrency").trim())) {
					validDeal.setToCurrency(record.get("toCurrency").trim());
				} else {
					System.out.println("Inavlid currency ISO Code");
					invalidDeal.setToCurrency("");
				}
			}

			// Check Date
			if (record.get("dealDate").trim().equals("")) {
				logger.info("Date field is Missing !! !!");
				invalidDeal.setDealDate("");
				isVaildDeal =false;
			} else {
				if (obj.isDateValid(record.get("dealDate").trim())) {
					DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = null;
					try {
						date = formatter.parse(record.get("dealDate").trim());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					validDeal.setDealDate(date);
				}
			}
			
			if (record.get("dealAmount").trim().equals("")) {
				isVaildDeal =false;
				logger.info("Deal Ammount field is Missing !! ");
				invalidDeal.setDealAmount("");
			} else
				validDeal.setDealAmount(Double.valueOf(record.get("dealAmount").trim()));

			if (isVaildDeal) {
				DealDAOImpl dealDao = new DealDAOImpl();
				dealDao.InsertDeal(validDeal);
			}
			else 
				System.out.println("You could not add this deal right now , many fields are missing please try again !!");
//			break;
		}
	}
}
