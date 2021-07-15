package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""Test to verify payload of UT003 flow""")

    label 'accepted_verification'

    input {

        triggeredBy('sendMessage()')
    }

    outputMessage {

        sentTo 'GAS.AFMS'

        body(file('UT003.xml').toString())


//        Example to verify payload in XML
//        bodyMatchers {
//            xPath('/test/duck/text()', byRegex("[0-9]{3}"))
//            xPath('/test/duck/text()', byCommand('equals($it)'))
//            xPath('/test/duck/xxx', byNull())
//            xPath('/test/duck/text()', byEquality())
//            xPath('/test/alpha/text()', byRegex(onlyAlphaUnicode()))
//            xPath('/test/alpha/text()', byEquality())
//            xPath('/test/number/text()', byRegex(number()))
//            xPath('/test/date/text()', byDate())
//            xPath('/test/dateTime/text()', byTimestamp())
//            xPath('/test/time/text()', byTime())
//            xPath('/test/*/complex/text()', byEquality())
//            xPath('/test/duck/@type', byEquality())
//        }

    }
}
