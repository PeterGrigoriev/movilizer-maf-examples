package com.movilizer.examples.groovy
/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class ExpandoDemo {
    static def main(args) {
        new ExpandoDemo().run()
    }

    def getCurrentYear = { ->
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(new Date())
        calendar.get(Calendar.YEAR)
    }

    def sayHi = { -> println "Hi! I'm " + name }
    def getAge = { -> getCurrentYear() - yearOfBirth }

    def Person(String name, int yearOfBirth) {
        return new Expando(
                name: name,
                yearOfBirth: yearOfBirth,
                sayHi      : sayHi,
                getAge     : getAge
        );
    }

    def run() {
        def peter = Person('Peter', 1975)
        peter.sayHi()
        println 'Peter is ' + peter.getAge() + ' years old'
    }
}
