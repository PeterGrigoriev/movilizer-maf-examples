package com.movilizer.examples.groovy

/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class SayHelloDemo {
    static def main(args) {
        new SayHelloDemo().run()
    }

    void run() {
        sayHello()
    }

    void sayHello() {
        print "hi"
    }
}
