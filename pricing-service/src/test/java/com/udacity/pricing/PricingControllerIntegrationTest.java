package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getPriceForVehicleId(){
        ResponseEntity<Price> priceResponse = this.restTemplate.getForEntity("http://localhost:" + this.port + "/services/price?vehicleId=1", Price.class);
        boolean priceIsGreaterThanZero = priceResponse.getBody().getPrice().compareTo(BigDecimal.ZERO) > 0;

        assertEquals(HttpStatus.OK, priceResponse.getStatusCode());
        assertNotNull(priceResponse.getBody());
        assertTrue(priceIsGreaterThanZero);
    }

}
