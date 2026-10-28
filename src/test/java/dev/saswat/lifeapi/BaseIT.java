package dev.saswat.lifeapi;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = TestLifeapiApplication.class)
@Import(TestcontainersConfiguration.class)
@AutoConfigureRestTestClient
public abstract class BaseIT {

    @Autowired
    protected RestTestClient restTestClient;
}
