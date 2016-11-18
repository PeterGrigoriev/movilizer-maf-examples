package com.movilizer.examples.groovy
/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class PseudoObjectsWithLexicalScopeDemo {
    static def main(args) {
        new PseudoObjectsWithLexicalScopeDemo().run()
    }

    def getCurrentYear = { ->
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
