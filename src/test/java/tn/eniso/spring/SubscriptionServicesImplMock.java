package tn.eniso.spring;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.eniso.spring.entities.Subscription;
import tn.eniso.spring.entities.TypeSubscription;
import tn.eniso.spring.repositories.ISubscriptionRepository;
import tn.eniso.spring.services.SubscriptionServicesImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SubscriptionServicesImplMock {

    @Mock
    ISubscriptionRepository iSubscriptionRepository;
    @InjectMocks
    SubscriptionServicesImpl subscriptionServices;


        List<Subscription> listSubscriptions = new ArrayList<Subscription>() {
            {
                add(new Subscription(1L,LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1),2f,TypeSubscription.ANNUAL));
                add(new Subscription(1L,LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1),2f,TypeSubscription.SEMESTRIEL));
                add(new Subscription(1L,LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 1),2f,TypeSubscription.MONTHLY));
            }
        };

    };


