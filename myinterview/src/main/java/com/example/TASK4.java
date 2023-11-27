package com.example;

import com.example.model.Employee;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Create an implementation of a Rest API client.
 * Prints out how many records exists for each gender and save this file to s3 bucket
 * API endpoint=> https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda
 * AWS s3 bucket => interview-digiage
 */
public class TASK4 {
    public static void main(String[] args) {
        String apiUrl = "https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda";
        int feminine = 0;
        int masculine = 0;

        try {
            String apiResponse = getAPI(apiUrl);

            List<Employee> employees = parseJson(apiResponse);

            for (Employee employee : employees) {
                if(employee.getGender().equals("F")) {
                    feminine++;
                } else if(employee.getGender().equals("M")) {
                    masculine++;
                }
            }

            System.out.println("Number of feminine registrations: " + feminine);
            System.out.println("Number of masculine registrations: " + masculine);

            // TODO criar e salvar o arquivo na AWS, não fiz porque ainda não tenho o conhecimento para tal...

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String getAPI(String url) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(url);
        HttpResponse response = httpClient.execute(getRequest);

        try (InputStream content = response.getEntity().getContent()) {
            StringBuilder result = new StringBuilder();
            int byteData;
            while ((byteData = content.read()) != -1) {
                result.append((char) byteData);
            }
            return result.toString();
        }
    }

    private static List<Employee> parseJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        List<Employee> employees = new ArrayList<>();
        for (JsonNode employeeNode : jsonNode) {
            Employee employee = objectMapper.treeToValue(employeeNode, Employee.class);
            employees.add(employee);
        }

        return employees;
    }
}
