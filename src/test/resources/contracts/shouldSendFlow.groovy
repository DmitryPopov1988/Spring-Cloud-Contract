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


        bodyMatchers {
            xPath('/formfillXML/header/ORIGINATORID/text()', byRegex(onlyAlphaUnicode()))
            xPath('/formfillXML/header/ORIGINATORROLECODE/text()', byRegex(onlyAlphaUnicode()))
            xPath('/formfillXML/header/CREATEDDATE/text()', byRegex('[0-9]{6}'))
            xPath('/formfillXML/header/CREATEDTIME/text()', byRegex('[0-9]{6}'))
            xPath('/formfillXML/body/record/K0533/text()', byRegex(number()))
        }
    }

}
