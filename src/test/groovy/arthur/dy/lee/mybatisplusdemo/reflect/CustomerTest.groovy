package arthur.dy.lee.mybatisplusdemo.reflect

import org.junit.runner.RunWith
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import spock.lang.Specification

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([Account])
class CustomerTest extends Specification {

    def "GetAccountType"() {
        setup:
        PowerMockito.mockStatic(Account.class);
        PowerMockito.when(Account.getType()).thenReturn("bb")
        Customer cust = new Customer();

        when:
        String ret = cust.getAccountType()

        then:
        ret == "bb"
    }
}
