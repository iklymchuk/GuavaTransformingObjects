package com.klymchuk;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Enums;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

public class TransformObjectsTest {
	
	@Test
	public void transform_string_to_enum () {
		List<String> days = Lists.newArrayList(
				"Monday",
				"Tuesday",
				"Wednesday");
		
		Function<String, Day> stringToDayEnum = Enums.stringConverter(Day.class);
		
		Iterable<Day> daysAsEnum = Iterables.transform(days, stringToDayEnum);
		
		for (Day day : daysAsEnum) {
			System.out.println(day);
			System.out.println("getClass is: "+day.getClass());
		}
	}
	
	@Test
	public void convert_from_oldTradeInvestment_to_newTradeInvestment () {
		
		List <OldTradeInvestment> oldTradeInvestment = Lists.newArrayList();
			oldTradeInvestment.add(new OldTradeInvestment(589, "Facebook inc", 57.51));
			oldTradeInvestment.add(new OldTradeInvestment(745, "Micron tec", 89.51));
			oldTradeInvestment.add(new OldTradeInvestment(985, "Ford Motors", 57.74));
			oldTradeInvestment.add(new OldTradeInvestment(256, "Sirius XM", 56.51));

		//convert a list of object
		//Function<F, T> - From object TO object
		Function<OldTradeInvestment, NewTradeInvestment> oldToNewTradeInvestmentFunction = new Function<OldTradeInvestment, NewTradeInvestment>() {
			
			@Override
			public NewTradeInvestment apply(OldTradeInvestment input) {
				NewTradeInvestment investment = new NewTradeInvestment();
					investment.setKey(Ints.stringConverter().reverse().convert(input.getOldKey()));
					investment.setName(input.getOldName());
					investment.setPrice(new BigDecimal(input.getOldPrice()));
				return investment;
			}
		};

		List<NewTradeInvestment> newTradeInvestmentConverted = Lists.transform(oldTradeInvestment, oldToNewTradeInvestmentFunction);
		System.out.println(newTradeInvestmentConverted);
		
		//convert object
			
		NewTradeInvestment facebookInvestment =  oldToNewTradeInvestmentFunction.apply(new OldTradeInvestment(589, "Facebook inc", 57.51));
		System.out.println(facebookInvestment);

	}
	
	@Test
	public void transform_list_to_map() {
		
		List <OldTradeInvestment> oldTradeInvestment = Lists.newArrayList();
		oldTradeInvestment.add(new OldTradeInvestment(589, "Facebook inc", 57.51));
		oldTradeInvestment.add(new OldTradeInvestment(745, "Micron tec", 89.51));
		oldTradeInvestment.add(new OldTradeInvestment(985, "Ford Motors", 57.74)); 
		oldTradeInvestment.add(new OldTradeInvestment(256, "Sirius XM", 56.51));

		ImmutableMap<Integer, OldTradeInvestment> investmentMap = Maps.uniqueIndex(oldTradeInvestment, new Function<OldTradeInvestment, Integer>() {

			@Override
			public Integer apply(OldTradeInvestment input) {
				return new Integer(input.getOldKey());
			}
		});
		
		System.out.println(investmentMap);
		
		/*
		{
		589=OldTradeInvestment
				{oldKey=589, oldName=Facebook inc, oldPrice=57.51},
		745=OldTradeInvestment
			{oldKey=745, oldName=Micron tec, oldPrice=89.51}, 
		985=OldTradeInvestment
			{oldKey=985, oldName=Ford Motors, oldPrice=57.74}, 
		256=OldTradeInvestment
			{oldKey=256, oldName=Sirius XM, oldPrice=56.51}
		}
		*/
	}
}
