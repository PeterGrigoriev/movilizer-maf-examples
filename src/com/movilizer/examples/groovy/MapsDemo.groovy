package com.movilizer.examples.groovy

/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class MapsDemo {
    static def main(args) {
        new MapsDemo().run()
    }

    def run() {
        demoEmptyMap()
        demoStringKeyShortcut()
        demoAvoidStringKeyShortcut()
        demoSpread()
        demoThereIsNoTypedMap()
    }

    def demoSpread() {
        def mapOne = [a: 1, b: 2]
        def mapTwo = [*: mapOne, c: 3, d:4]
        assert mapTwo == [a: 1, b: 2, c: 3, d:4]
    }

    def demoThereIsNoTypedMap() {
        def map = new LinkedHashMap<Integer, Map>()
        // effectively equals to:
        // map = new LinkedHashMap() or map = [;]

        // due to type erasure this will not throw at runtime!
        map['abc'] = 1
    }

    def demoStringKeyShortcut() {
        def map = [year: 1975, name: 'peter']

        // this will be java.util.LinkedHashMap
        assert map instanceof Map

        assert map['year'] == 1975
        assert map.year == 1975
        assert map.get('year') == 1975


    }

    def demoEmptyMap() {
        def emptyMap = [:]
        assert emptyMap instanceof Map
    }

    def demoAvoidStringKeyShortcut() {
        def key = 'peter'
        assert [key: 1975] == ['key': 1975]
        assert ['peter': 1975] == [(key): 1975]
    }
}
