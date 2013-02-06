require.config({
    baseUrl: "/resources/js/",
    dir: "./",

    // 3rd party script alias names
    paths: {

        // Core Libraries
        jquery: "libs/jquery",
        kendo: "libs/kendo/kendo.web",
        underscore: "libs/lodash",
        backbone: "libs/backbone",

        // Require.js Plugins
        use: "plugins/use",
        text: "plugins/text"

    },

    // Sets the use.js configuration for your application
    use: {

        backbone: {
            deps: ["use!underscore", "jquery"],
            attach: "Backbone"  //attaches "Backbone" to the window object
        },

        underscore: {
            attach: "_" //attaches "_" to the window object
        }

    }, // end Use.js Configuration

    // Modules to be optimized:
    modules: [

        {
            name: "mobile"
        },

        {
            name: "desktop"
        }
    ]

});