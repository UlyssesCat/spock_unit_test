import spock.lang.Specification
import spock.lang.Unroll

class SumTest extends Specification {
    def sum = new Sum();
    def "sum should return param1+param2"() {
        expect:
        sum.sum(1,1) == 2
    }

    def "Set Blocks"() {
        setup://given:   在此block定义局部变量 mock函数
        def stack = new Stack()
        def elem = "push me"
    }

    def "When and Then Blocks"(){
        when:
        stack.push(elem)
        then:
        !stack.empty
        stack.size() == 1
        stack.peek() == elem
    }

    def "Assert"() {
        stack = new Stack()
        assert stack.empty
    }//条件类似junit中的assert，就像上面的例子，在then或expect中会默认assert所有返回值是boolean型的顶级语句。如果要在其它地方增加断言，需要显式增加assert关键字

    def "Thrown"() {
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
        stack.empty
    }

    def "Thrown2"() {
        when:
        stack.pop()
        then:
        def e = thrown(EmptyStackException)
        e.cause == null
    }

    def "HashMap accepts null key"() {
        setup:
        def map = new HashMap()

        when:
        map.put(null, "elem")

        then:
        notThrown(NullPointerException)
    }//如果要验证没有抛出某种异常，可以用notThrown()

    def "Expect Blocks"() {
        expect:
        Math.max(1, 2) == 2
    }/*expect可以看做精简版的when+then，如：
    when:
    def x = Math.max(1, 2)
    then:
    x == 2*/

    def setup() {}             // run before every feature method
    def cleanup() {}           // run after every feature method
    def setupSpec() {}        // run before the first feature method
    def cleanupSpec() {}       // run after the last feature method



    def "No Use Where Block"() {
        expect:
        // exercise math method for a few different inputs
        Math.max(1, 3) == 3
        Math.max(7, 4) == 7
        Math.max(0, 0) == 0
    }

    //如果使用@Unroll，会把where block当作三个方法运行
    def "Use Where Block"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        3 | 5 || 5
        7 | 0 || 7
        0 | 0 || 0
    }//上述例子实际会跑三次测试，相当于在for循环中执行三次测试，a/b/c的值分别为3/5/5,7/0/7和0/0/0。如果在方法前声明@Unroll，则会当成三个方法运行。
    /*除此之外，where block还有两种数据定义的方法，并且可以结合使用，如：
    where:
    a | _
    3 | _
    7 | _
    0 | _
    b << [5, 0, 0]
    c = a > b ? a : b*/




}