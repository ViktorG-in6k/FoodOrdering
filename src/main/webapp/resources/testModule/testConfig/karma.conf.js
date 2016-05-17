module.exports = function(config) {
  config.set({
    basePath: '../',
    frameworks: ['jasmine'],
    files: [
        '../js/lib/angular.min.js',
        '../js/lib/angular-mocks.js',
        '../js/eventDetailModule/services.js',
        'test/first.js'
    ],
    exclude: [
    ],
    preprocessors: {
    },
    reporters: ['progress'],
    port: 9876,
    colors: true,
    logLevel: config.LOG_INFO,
    autoWatch: true,
    browsers: ['Chrome'],
    plugins: [
      'karma-chrome-launcher',
      'karma-firefox-launcher',
      'karma-jasmine'
    ],
    singleRun: false,
    concurrency: Infinity
  })
}
