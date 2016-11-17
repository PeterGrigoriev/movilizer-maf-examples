package com.movilizer.examples.groovy

import static java.lang.Math.*

/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class PseudoObjectsDemo {
    static def main(args) {
        new PseudoObjectsDemo().run()
    }

    static def getCurrentYear = { ->
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.get(Calendar.YEAR)
    }

    // maps+closures for something like constructor
    //
    def Person(String name, int yearOfBirth) {
        [
                name       : name,
                yearOfBirth: yearOfBirth,
                sayHi      : { -> println "Hi! I'm " + name },
                getAge     : { -> getCurrentYear() - yearOfBirth }
        ];
    }



    def run() {
        def peter = Person('Peter', 1975)
        peter.sayHi()
        println 'Peter is ' + peter.getAge() + ' years old'
    }
}
