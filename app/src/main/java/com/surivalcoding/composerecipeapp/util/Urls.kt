package com.surivalcoding.composerecipeapp.util

object Urls {

    val RECIPE_JSON = """
       {
         "recipes": [
           {
             "category": "Dinner",
             "id": 1,
             "name": "Traditional spare ribs baked",
             "image": "https://cdn.pixabay.com/photo/2017/11/10/15/04/steak-2936531_1280.jpg",
             "chef": "Chef John",
             "time": "20 min",
             "rating": 1.3,
             "filterTime" : "Newest"
             "isBookMarked": false,
             "video" : "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
             "ingredients": [
               {
                 "ingredient": {
                   "id": 3,
                   "name": "Pork",
                   "image": "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg"
                 },
                 "amount": 500
               },
               {
                 "ingredient": {
                   "id": 9,
                   "name": "Onion",
                   "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
                 },
                 "amount": 50
               },
               {
                 "ingredient": {
                   "id": 8,
                   "name": "Pepper",
                   "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
                 },
                 "amount": 10
               },
               {
                 "ingredient": {
                   "id": 1,
                   "name": "Tomato",
                   "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
                 },
                 "amount": 100
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 2,
             "category": "Chinese",
             "name": "Spice roasted chicken with flavored rice",
             "image": "https://cdn.pixabay.com/photo/2018/12/04/16/49/tandoori-3856045_1280.jpg",
             "chef": "Mark Kelvin",
             "time": "20 min",
             "rating": 2.5,
             "filterTime" : "Oldest"
             "isBookMarked": false,
             "video": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", 
             "ingredients": [
               {
                 "ingredient": {
                   "id": 6,
                   "name": "Chicken",
                   "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
                 },
                 "amount": 300
               },
               {
                 "ingredient": {
                   "id": 4,
                   "name": "Rice",
                   "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
                 },
                 "amount": 200
               },
               {
                 "ingredient": {
                   "id": 8,
                   "name": "Pepper",
                   "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
                 },
                 "amount": 5
               },
               {
                 "ingredient": {
                   "id": 3,
                   "name": "Pork",
                   "image": "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg"
                 },
                 "amount": 500
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 3,
             "category": "Local Dish",
             "name": "Spicy fried rice mix chicken bali",
             "image": "https://cdn.pixabay.com/photo/2019/09/07/19/02/spanish-paella-4459519_1280.jpg",
             "chef": "Spicy Nelly",
             "time": "20 min",
             "rating": 3.3,
             "filterTime" : "Popularity"
             "isBookMarked": false,
             "video": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4", 
             "ingredients": [
               {
                 "ingredient": {
                   "id": 6,
                   "name": "Chicken",
                   "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
                 },
                 "amount": 200
               },
               {
                 "ingredient": {
                   "id": 4,
                   "name": "Rice",
                   "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
                 },
                 "amount": 150
               },
               {
                 "ingredient": {
                   "id": 1,
                   "name": "Tomato",
                   "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
                 },
                 "amount": 100
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "category": "Lunch",
             "id": 4,
             "name": "Ttekbokki",
             "image": "https://cdn.pixabay.com/photo/2017/07/27/16/48/toppokki-2545943_1280.jpg",
             "chef": "Kim Dahee",
             "time": "30 min",
             "rating": 4.5,
             "filterTime" : "Popularity"
             "isBookMarked": false,
             "video": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
             "ingredients": [],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 5,
             "category": "Vegetables",
             "name": "Grilled salmon with avocado salsa",
             "image": "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
             "chef": "Alice Johnson",
             "time": "25 min",
             "rating": 5.0,
             "filterTime" : "Oldest"
             "isBookMarked": false,
             "video" : "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 5,
                   "name": "Avocado",
                   "image": "https://cdn.pixabay.com/photo/2020/01/02/01/43/avocado-4734786_1280.jpg"
                 },
                 "amount": 150
               },
               {
                 "ingredient": {
                   "id": 8,
                   "name": "Pepper",
                   "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg"
                 },
                 "amount": 5
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 6,
             "category": "Spanish",
             "name": "Beef Wellington",
             "image": "https://cdn.pixabay.com/photo/2019/10/22/10/11/beef-wellington-4568239_1280.jpg",
             "chef": "Gordon Ramsay",
             "time": "45 min",
             "rating": 4.1,
             "filterTime" : "Newest"
             "isBookMarked": false,
             "video": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 2,
                   "name": "Beef",
                   "image": "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png"
                 },
                 "amount": 500
               },
               {
                 "ingredient": {
                   "id": 9,
                   "name": "Onion",
                   "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
                 },
                 "amount": 100
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 7,
             "category": "Dinner",
             "name": "Classic Margherita Pizza",
             "image": "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
             "chef": "Mario Batali",
             "time": "15 min",
             "rating": 3.7,
             "filterTime" : "Oldest"
             "isBookMarked": false,
             "video": "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 1,
                   "name": "Tomato",
                   "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg"
                 },
                 "amount": 200
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 8,
             "category": "Local Dish",
             "name": "Sushi Platter",
             "image": "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
             "chef": "Jiro Ono",
             "time": "60 min",
             "rating": 2.3,
             "filterTime" : "Popularity"
             "isBookMarked": false,
             "video" : "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 6,
                   "name": "Chicken",
                   "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg"
                 },
                 "amount": 200
               },
               {
                 "ingredient": {
                   "id": 4,
                   "name": "Rice",
                   "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg"
                 },
                 "amount": 100
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 9,
             "category": "BreakFast",
             "name": "French Onion Soup",
             "image": "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
             "chef": "Julia Child",
             "time": "40 min",
             "rating": 1.5,
             "filterTime" : "Newest"
             "isBookMarked": false,
             "video" : "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 9,
                   "name": "Onion",
                   "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg"
                 },
                 "amount": 300
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           },
           {
             "id": 10,
             "category": "Cereal",
             "name": "Chocolate Lava Cake",
             "image": "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
             "chef": "Paul Hollywood",
             "time": "30 min",
             "rating": 4.8,
             "filterTime" : "Newest"
             "isBookMarked": false,
             "video" : "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4",
             "ingredients": [
               {
                 "ingredient": {
                   "id": 7,
                   "name": "Sugar",
                   "image": "https://cdn.pixabay.com/photo/2014/11/28/19/10/lump-sugar-549096_1280.jpg"
                 },
                 "amount": 100
               }
             ],
             "procedure": [
               "Preheat the oven to 180°C (356°F).",
               "Prepare the pork and cut it into appropriate sizes.",
               "Make the seasoning and coat the pork evenly.",
               "Place in the oven and bake for 40 minutes.",
               "Serve the cooked dish on a plate and enjoy."
             ]
           }
         ]
       }
    """.trimIndent()


    val DEV_RECIPE_JSON = """
        {
          "recipes": [
            {
              "category": "Cereal",
              "id": 1,
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Chef John",
              "time": "20 min",
              "rating": 4.0,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 3,
                    "name": "Pork",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 500
                },
                {
                  "ingredient": {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 50
                },
                {
                  "ingredient": {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 10
                },
                {
                  "ingredient": {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 100
                }
              ]
            },
            {
              "id": 2,
              "category": "Vegetables",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Mark Kelvin",
              "time": "20 min",
              "rating": 4.0,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 300
                },
                {
                  "ingredient": {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 200
                },
                {
                  "ingredient": {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 5
                },
                {
                  "ingredient": {
                    "id": 3,
                    "name": "Pork",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 500
                }
              ]
            },
            {
              "id": 3,
              "category": "Dinner",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Spicy Nelly",
              "time": "20 min",
              "rating": 4.0,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 200
                },
                {
                  "ingredient": {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 150
                },
                {
                  "ingredient": {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 100
                }
              ]
            },
            {
              "category": "Chinese",
              "id": 4,
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Kim Dahee",
              "time": "30 min",
              "rating": 5.0,
              "isBookMarked" : false,
              "ingredients": []
            },
            {
              "id": 5,
              "category": "Local Dish",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Alice Johnson",
              "time": "25 min",
              "rating": 4.5,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 5,
                    "name": "Avocado",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 150
                },
                {
                  "ingredient": {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 5
                }
              ]
            },
            {
              "id": 6,
              "category": "Fruit",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Gordon Ramsay",
              "time": "45 min",
              "rating": 5.0,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 2,
                    "name": "Beef",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 500
                },
                {
                  "ingredient": {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 100
                }
              ]
            },
            {
              "id": 7,
              "category": "BreakFast",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Mario Batali",
              "time": "15 min",
              "rating": 4.3,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 200
                }
              ]
            },
            {
              "id": 8,
              "category": "Spanish",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Jiro Ono",
              "time": "60 min",
              "rating": 4.8,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 200
                },
                {
                  "ingredient": {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 100
                }
              ]
            },
            {
              "id": 9,
              "category": "Lunch",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Julia Child",
              "time": "40 min",
              "rating": 4.6,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 300
                }
              ]
            },
            {
              "id": 10,
              "category": "French",
              "name": "DEV 환경 이라구!!",
              "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg",
              "chef": "Paul Hollywood",
              "time": "30 min",
              "rating": 4.9,
              "isBookMarked" : false,
              "ingredients": [
                {
                  "ingredient": {
                    "id": 7,
                    "name": "Sugar",
                    "image": "https://kid.chosun.com/site/data/img_dir/2005/09/11/20050911000042110_200.jpg"
                  },
                  "amount": 100
                }
              ]
            }
          ]
        }
    """.trimIndent()
}