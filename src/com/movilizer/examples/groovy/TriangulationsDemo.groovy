package com.movilizer.examples.groovy

import static java.lang.Math.*

/**
 * @author Peter.Grigoriev@movilizer.com.
 */
class TriangulationsDemo {
    static def main(args) {
        new TriangulationsDemo().run()
    }


    static def GpsCoordinates(double latitude, double longitude) {
        [
                latitude    : latitude,
                longitude   : longitude,
                distanceFrom: { that ->
                    double R = 6371; // km
                    double radianLatitudeDistance = toRadians(that.latitude - latitude);
                    double radianLongtitudeDistance = toRadians(that.longitude - longitude);
                    double a = sin(radianLatitudeDistance / 2) * sin(radianLatitudeDistance / 2) +
                            cos(toRadians(latitude)) * cos(toRadians(that.latitude)) *
                            sin(radianLongtitudeDistance / 2) * sin(radianLongtitudeDistance / 2);
                    R * 2 * atan2(sqrt(a), sqrt(1 - a));
                }
        ];
    }

    static def City(String name, coordinates) {
        [
                name       : name,
                coordinates: coordinates,
                distanceTo: {
                    otherCity -> (long) coordinates.distanceFrom(otherCity.coordinates)
                }
        ]
    }

    def run() {
        def berlin = City("Berlin", GpsCoordinates(52.52, 13.405))
        def mannheim = City("Mannheim", GpsCoordinates(49.4875, 8.466))

        print "The distance between " + berlin.name + " and " + mannheim.name + " is " +
                berlin.distanceTo(mannheim) + " km "
    }
}
