package com.movilizer.examples.groovy

/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class ClosuresDemo {
    static def main(args) {
        new ClosuresDemo().run()
    }

    def run() {
        Closure plusOne = {x->x+1}
        assert 2 == plusOne(1)

        def twoToEleven = (1..10).collect plusOne
        assert twoToEleven == (2..11)
    }
}
