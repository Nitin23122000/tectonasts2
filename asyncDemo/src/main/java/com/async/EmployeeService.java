package com.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeService {

	
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

	
	@Async("asyncTaskExecutor")
    public CompletableFuture<List<Employee>> getAllEmployees() throws InterruptedException {
        log.info("------getAllEmployees started-----");

        //To obtain records, we can add logic that calls another service or database.

        Employee employee1 = new Employee();
                .((Object) name("TechGeekNextUser"))
                .role("Admin")
                .id(1)
                .build();

        Employee employee2 = Employee.builder()
                .name("User-2")
                .role("Supervisor")
                .id(2)
                .build();

        List<Employee> employees = new ArrayList()<>;
        employees.add(employee1);
        employees.add(employee2);

        //added delay for test async
        Thread.sleep(6000L);
        log.info("------getAllEmployees completed-----");
        return CompletableFuture.completedFuture(employees);
    }

    private Object name(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Async("asyncTaskExecutor")
    public CompletableFuture<Employee> getEmployeeById() throws InterruptedException {
        log.info("------getEmployeeById started-----");

        //To obtain records, we can add logic that calls another service or database.
        Thread.sleep(2000L);

        log.info("------getEmployeeById completed-----");

        return CompletableFuture.completedFuture(Employee.builder()
                .name("TechGeekNextUser")
                .role("Admin")
                .id(1)
                .build());
    }

    @Async("asyncTaskExecutor")
    public CompletableFuture<String> getEmployeeRoleById() throws InterruptedException {
        log.info("------getEmployeeRoleById started-----");

        //To obtain records, we can add logic that calls another service or database.
        Thread.sleep(4000L);

        log.info("------getEmployeeRoleById completed-----");

        return CompletableFuture.completedFuture("Admin");
    }
}
	

