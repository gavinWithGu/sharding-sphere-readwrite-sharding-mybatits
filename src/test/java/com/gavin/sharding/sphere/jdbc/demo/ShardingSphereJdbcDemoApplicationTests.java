package com.gavin.sharding.sphere.jdbc.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gavin.poc.sharding.sphere.jdbc.ShardingSphereJdbcDemoApplication;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.NoShardingTable;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.OperationTime;
import com.gavin.poc.sharding.sphere.jdbc.demo.domain.entity.User;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.NoShardingService;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.OperationTimeService;
import com.gavin.poc.sharding.sphere.jdbc.demo.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingSphereJdbcDemoApplication.class)
class ShardingSphereJdbcDemoApplicationTests {

	@Autowired
    private UserService userService;
	
	@Autowired
    private OperationTimeService operationTimeService;
	
	@Autowired
    private NoShardingService noShardingService;


	/**
     * Simulation of data insert: table operation_time
     */
    @Test
    public void testInsertForOp(){
        for (int i = 10; i <= 12; i++) {
        	try {
        		OperationTime operationTime = new OperationTime();
        		operationTime.setCount(i);
        		operationTime.setThingId(String.valueOf(i));
        		operationTime.setUnitId(String.valueOf(i));
//        		operationTime.setUnitIdCount(i *10);
        		operationTime.setCreatedAt(new Date());
        		operationTime.setPower(0);
        		operationTimeService.save(operationTime);
        		
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
    }
    
    
    /**
     * Simulation of read-write split
     */
    @Test
    public void testSelectByThingId(){
    	try {
    		Map<String, Object> input = new HashMap<String, Object>();
    		input.put("thingId", 1);
    		
    		List<OperationTime>  result = operationTimeService.selectByThingId(input);
    		for (OperationTime item : result) {
    			System.out.println(item.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Simulation of read-write split
     */
    @Test
    public void testComplexSelect(){
    	try {
    		Map<String, Object> input = new HashMap<String, Object>();
    		input.put("thingId", 2);
    		input.put("startDate", "2024-01-08 00:00:00");
    		input.put("endDate", "2024-02-08 23:59:59");
    		input.put("power", "2");
    		
    		Map<String, Object>  result = operationTimeService.selectByParams(input);
    		for (String key : result.keySet()) {
    			Object object = result.get(key);
    			System.out.println("Key: "+key+", value: "+object);
    			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    
    
    
    
    
	
	/**
     * Simulation of data insert: table sharding 
     */
    @Test
    public void testInsert(){
        for (int i = 1; i <= 3; i++) {
        	try {
        		User user = new User();
        		user.setName("CS_Team_Go "+i);
        		user.setId((long)i);
        		user.setAge(i);
        		userService.save(user);
        		
        		NoShardingTable noShardingTable = new NoShardingTable();
        		noShardingTable.setId((long)i);
        		noShardingTable.setName("CS_Team_Go "+i);
        		noShardingService.save(noShardingTable);
			} catch (Exception e) {
				e.printStackTrace();
			}
           
        }
    }


    /**
     * Simulation of read-write split
     */
    @Test
    @Transactional
    public void testSelectAll(){
    	try {
    		List<User> users = userService.list();  //SELECT  id,name,age  FROM tb_student_1 UNION ALL SELECT  id,name,age  FROM tb_student_2 UNION ALL SELECT  id,name,age  FROM tb_student_3
            for (User user : users) {
    			System.out.println(user.toString());
    		}

            User one = userService.getById(1);
            System.out.println("Fetch data for id : 1, "+one.toString());

            User one2 = userService.getById(3l);
            System.out.println("Fetch data for id : 3, "+one2.toString());
            
            
            NoShardingTable one3 = noShardingService.getById(1l);
            System.out.println("Fetch data for id for table no_sharding: 1, "+one3.toString());

            NoShardingTable one4 = noShardingService.getById(3l);
            System.out.println("Fetch data for id for table no_sharding: 3, "+one4.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
