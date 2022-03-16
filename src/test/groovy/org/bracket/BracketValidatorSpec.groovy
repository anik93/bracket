package org.bracket

import spock.lang.Specification

class BracketValidatorSpec extends Specification {

    def bracketValidator = new BracketValidator()

    def 'should test bracket validator'() {
        when:
        def result = bracketValidator.isBracketClosed(brackets)

        then:
        result == expected

        where:
        brackets       || expected
        "(){}[]"       || true
        "([{}])"       || true
        "(}"           || false
        "[(])"         || false
        "[({})](]"     || false
        "(({}]()"      || false
        "{[("          || false
        "}])"          || false
        "(){}[]{[()]}" || true
    }
}
