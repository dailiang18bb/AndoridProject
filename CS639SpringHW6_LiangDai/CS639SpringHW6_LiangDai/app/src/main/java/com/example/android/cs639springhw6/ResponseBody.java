package com.example.android.cs639springhw6;

public class ResponseBody {


    /* ResponseBody from WWO

    {
    "data": {
        "request": [
            {
                "type": "City",
                "query": "White Plains, United States of America"
            }
        ],
        "current_condition": [
            {
                "observation_time": "06:36 PM",
                "temp_C": "16",
                "temp_F": "61",
                "weatherCode": "113",
                "weatherIconUrl": [
                    {
                        "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0001_sunny.png"
                    }
                ],
                "weatherDesc": [
                    {
                        "value": "Sunny"
                    }
                ],
                "windspeedMiles": "11",
                "windspeedKmph": "17",
                "winddirDegree": "140",
                "winddir16Point": "SE",
                "precipMM": "0.0",
                "humidity": "23",
                "visibility": "16",
                "pressure": "1031",
                "cloudcover": "0",
                "FeelsLikeC": "16",
                "FeelsLikeF": "61"
            }
        ],
        "weather": [
            {
                "date": "2018-04-23",
                "astronomy": [
                    {
                        "sunrise": "06:04 AM",
                        "sunset": "07:44 PM",
                        "moonrise": "12:53 PM",
                        "moonset": "02:35 AM",
                        "moon_phase": "First Quarter",
                        "moon_illumination": "41"
                    }
                ],
                "maxtempC": "14",
                "maxtempF": "58",
                "mintempC": "3",
                "mintempF": "38",
                "totalSnow_cm": "0.0",
                "sunHour": "11.6",
                "uvIndex": "7",
                "hourly": [
                    {
                        "time": "0",
                        "tempC": "5",
                        "tempF": "41",
                        "windspeedMiles": "0",
                        "windspeedKmph": "0",
                        "winddirDegree": "18",
                        "winddir16Point": "NNE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Clear"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "60",
                        "visibility": "20",
                        "pressure": "1030",
                        "cloudcover": "3",
                        "HeatIndexC": "6",
                        "HeatIndexF": "43",
                        "DewPointC": "-1",
                        "DewPointF": "30",
                        "WindChillC": "6",
                        "WindChillF": "43",
                        "WindGustMiles": "3",
                        "WindGustKmph": "5",
                        "FeelsLikeC": "6",
                        "FeelsLikeF": "43",
                        "chanceofrain": "0",
                        "chanceofremdry": "90",
                        "chanceofwindy": "0",
                        "chanceofovercast": "26",
                        "chanceofsunshine": "88",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "300",
                        "tempC": "3",
                        "tempF": "38",
                        "windspeedMiles": "1",
                        "windspeedKmph": "2",
                        "winddirDegree": "5",
                        "winddir16Point": "N",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Clear"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "64",
                        "visibility": "20",
                        "pressure": "1030",
                        "cloudcover": "0",
                        "HeatIndexC": "4",
                        "HeatIndexF": "39",
                        "DewPointC": "-2",
                        "DewPointF": "28",
                        "WindChillC": "3",
                        "WindChillF": "38",
                        "WindGustMiles": "6",
                        "WindGustKmph": "9",
                        "FeelsLikeC": "3",
                        "FeelsLikeF": "38",
                        "chanceofrain": "0",
                        "chanceofremdry": "90",
                        "chanceofwindy": "0",
                        "chanceofovercast": "0",
                        "chanceofsunshine": "87",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "600",
                        "tempC": "5",
                        "tempF": "40",
                        "windspeedMiles": "6",
                        "windspeedKmph": "9",
                        "winddirDegree": "22",
                        "winddir16Point": "NNE",
                        "weatherCode": "116",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0004_black_low_cloud.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Partly cloudy"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "59",
                        "visibility": "20",
                        "pressure": "1032",
                        "cloudcover": "1",
                        "HeatIndexC": "5",
                        "HeatIndexF": "42",
                        "DewPointC": "-2",
                        "DewPointF": "29",
                        "WindChillC": "4",
                        "WindChillF": "39",
                        "WindGustMiles": "6",
                        "WindGustKmph": "10",
                        "FeelsLikeC": "4",
                        "FeelsLikeF": "39",
                        "chanceofrain": "0",
                        "chanceofremdry": "90",
                        "chanceofwindy": "0",
                        "chanceofovercast": "15",
                        "chanceofsunshine": "85",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "900",
                        "tempC": "9",
                        "tempF": "48",
                        "windspeedMiles": "5",
                        "windspeedKmph": "8",
                        "winddirDegree": "59",
                        "winddir16Point": "ENE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0001_sunny.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Sunny"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "46",
                        "visibility": "20",
                        "pressure": "1033",
                        "cloudcover": "1",
                        "HeatIndexC": "10",
                        "HeatIndexF": "49",
                        "DewPointC": "-1",
                        "DewPointF": "30",
                        "WindChillC": "9",
                        "WindChillF": "48",
                        "WindGustMiles": "6",
                        "WindGustKmph": "10",
                        "FeelsLikeC": "9",
                        "FeelsLikeF": "48",
                        "chanceofrain": "0",
                        "chanceofremdry": "85",
                        "chanceofwindy": "0",
                        "chanceofovercast": "30",
                        "chanceofsunshine": "83",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "1200",
                        "tempC": "13",
                        "tempF": "55",
                        "windspeedMiles": "6",
                        "windspeedKmph": "9",
                        "winddirDegree": "113",
                        "winddir16Point": "ESE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0001_sunny.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Sunny"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "36",
                        "visibility": "20",
                        "pressure": "1032",
                        "cloudcover": "0",
                        "HeatIndexC": "14",
                        "HeatIndexF": "57",
                        "DewPointC": "-1",
                        "DewPointF": "30",
                        "WindChillC": "14",
                        "WindChillF": "57",
                        "WindGustMiles": "6",
                        "WindGustKmph": "10",
                        "FeelsLikeC": "14",
                        "FeelsLikeF": "57",
                        "chanceofrain": "0",
                        "chanceofremdry": "83",
                        "chanceofwindy": "0",
                        "chanceofovercast": "0",
                        "chanceofsunshine": "93",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "1500",
                        "tempC": "14",
                        "tempF": "57",
                        "windspeedMiles": "8",
                        "windspeedKmph": "13",
                        "winddirDegree": "145",
                        "winddir16Point": "SE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0001_sunny.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Sunny"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "32",
                        "visibility": "20",
                        "pressure": "1031",
                        "cloudcover": "0",
                        "HeatIndexC": "15",
                        "HeatIndexF": "58",
                        "DewPointC": "-2",
                        "DewPointF": "28",
                        "WindChillC": "15",
                        "WindChillF": "58",
                        "WindGustMiles": "9",
                        "WindGustKmph": "14",
                        "FeelsLikeC": "15",
                        "FeelsLikeF": "58",
                        "chanceofrain": "0",
                        "chanceofremdry": "87",
                        "chanceofwindy": "0",
                        "chanceofovercast": "0",
                        "chanceofsunshine": "90",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "1800",
                        "tempC": "13",
                        "tempF": "55",
                        "windspeedMiles": "8",
                        "windspeedKmph": "13",
                        "winddirDegree": "154",
                        "winddir16Point": "SSE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0001_sunny.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Sunny"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "41",
                        "visibility": "20",
                        "pressure": "1031",
                        "cloudcover": "0",
                        "HeatIndexC": "14",
                        "HeatIndexF": "58",
                        "DewPointC": "-1",
                        "DewPointF": "30",
                        "WindChillC": "13",
                        "WindChillF": "56",
                        "WindGustMiles": "12",
                        "WindGustKmph": "20",
                        "FeelsLikeC": "13",
                        "FeelsLikeF": "56",
                        "chanceofrain": "0",
                        "chanceofremdry": "86",
                        "chanceofwindy": "0",
                        "chanceofovercast": "0",
                        "chanceofsunshine": "89",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    },
                    {
                        "time": "2100",
                        "tempC": "10",
                        "tempF": "49",
                        "windspeedMiles": "6",
                        "windspeedKmph": "10",
                        "winddirDegree": "157",
                        "winddir16Point": "SSE",
                        "weatherCode": "113",
                        "weatherIconUrl": [
                            {
                                "value": "http://cdn.worldweatheronline.net/images/wsymbols01_png_64/wsymbol_0008_clear_sky_night.png"
                            }
                        ],
                        "weatherDesc": [
                            {
                                "value": "Clear"
                            }
                        ],
                        "precipMM": "0.0",
                        "humidity": "60",
                        "visibility": "20",
                        "pressure": "1031",
                        "cloudcover": "0",
                        "HeatIndexC": "13",
                        "HeatIndexF": "55",
                        "DewPointC": "0",
                        "DewPointF": "33",
                        "WindChillC": "10",
                        "WindChillF": "50",
                        "WindGustMiles": "10",
                        "WindGustKmph": "16",
                        "FeelsLikeC": "10",
                        "FeelsLikeF": "50",
                        "chanceofrain": "0",
                        "chanceofremdry": "83",
                        "chanceofwindy": "0",
                        "chanceofovercast": "0",
                        "chanceofsunshine": "92",
                        "chanceoffrost": "0",
                        "chanceofhightemp": "0",
                        "chanceoffog": "0",
                        "chanceofsnow": "0",
                        "chanceofthunder": "0"
                    }
                ]
            }
        ],
        "ClimateAverages": [
            {
                "month": [
                    {
                        "index": "1",
                        "name": "January",
                        "avgMinTemp": "-3.5",
                        "avgMinTemp_F": "25.7",
                        "absMaxTemp": "3.8",
                        "absMaxTemp_F": "38.8",
                        "avgDailyRainfall": "3.56"
                    },
                    {
                        "index": "2",
                        "name": "February",
                        "avgMinTemp": "-2.5",
                        "avgMinTemp_F": "27.5",
                        "absMaxTemp": "6.1",
                        "absMaxTemp_F": "43.0",
                        "avgDailyRainfall": "4.29"
                    },
                    {
                        "index": "3",
                        "name": "March",
                        "avgMinTemp": "1.1",
                        "avgMinTemp_F": "34.0",
                        "absMaxTemp": "12.8",
                        "absMaxTemp_F": "55.0",
                        "avgDailyRainfall": "4.50"
                    },
                    {
                        "index": "4",
                        "name": "April",
                        "avgMinTemp": "8.0",
                        "avgMinTemp_F": "46.4",
                        "absMaxTemp": "16.1",
                        "absMaxTemp_F": "61.0",
                        "avgDailyRainfall": "3.47"
                    },
                    {
                        "index": "5",
                        "name": "May",
                        "avgMinTemp": "14.2",
                        "avgMinTemp_F": "57.6",
                        "absMaxTemp": "24",
                        "absMaxTemp_F": "75.2",
                        "avgDailyRainfall": "3.77"
                    },
                    {
                        "index": "6",
                        "name": "June",
                        "avgMinTemp": "19.3",
                        "avgMinTemp_F": "66.7",
                        "absMaxTemp": "27.8",
                        "absMaxTemp_F": "82.0",
                        "avgDailyRainfall": "4.68"
                    },
                    {
                        "index": "7",
                        "name": "July",
                        "avgMinTemp": "23.4",
                        "avgMinTemp_F": "74.1",
                        "absMaxTemp": "32.6",
                        "absMaxTemp_F": "90.7",
                        "avgDailyRainfall": "3.92"
                    },
                    {
                        "index": "8",
                        "name": "August",
                        "avgMinTemp": "22.2",
                        "avgMinTemp_F": "72.0",
                        "absMaxTemp": "30.9",
                        "absMaxTemp_F": "87.6",
                        "avgDailyRainfall": "3.84"
                    },
                    {
                        "index": "9",
                        "name": "September",
                        "avgMinTemp": "17.4",
                        "avgMinTemp_F": "63.3",
                        "absMaxTemp": "27.8",
                        "absMaxTemp_F": "82.0",
                        "avgDailyRainfall": "2.68"
                    },
                    {
                        "index": "10",
                        "name": "October",
                        "avgMinTemp": "11.2",
                        "avgMinTemp_F": "52.2",
                        "absMaxTemp": "19.2",
                        "absMaxTemp_F": "66.6",
                        "avgDailyRainfall": "3.81"
                    },
                    {
                        "index": "11",
                        "name": "November",
                        "avgMinTemp": "4.9",
                        "avgMinTemp_F": "40.8",
                        "absMaxTemp": "12.9",
                        "absMaxTemp_F": "55.2",
                        "avgDailyRainfall": "2.70"
                    },
                    {
                        "index": "12",
                        "name": "December",
                        "avgMinTemp": "0.9",
                        "avgMinTemp_F": "33.6",
                        "absMaxTemp": "10.9",
                        "absMaxTemp_F": "51.6",
                        "avgDailyRainfall": "4.47"
                    }
                ]
            }
        ]
    }
}
     */
}
