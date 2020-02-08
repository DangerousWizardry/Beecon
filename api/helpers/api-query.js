module.exports = {


  friendlyName: 'API Query',


  description: 'Send an API request to the application API',


  inputs: {

    request: {
      friendlyName: 'Request url',
      description: 'The requested url you want to retrieve.',
      type: 'string'
    },

    parameters: {
      description: 'Array of parameters you want to use in your API Call',
      type: 'ref',
      defaultsTo: ""
    }

  },


  exits: {

    success: {
      outputFriendlyName: 'API Result',
      outputDescription: 'API Result of your request',
    },

    apiFailed: {
      description: 'Could not achieve this request'
    }

  },


  fn: async function (inputs, exits) {
    var request = require('request');
    request.get({
      url: "http://localhost:4910"+inputs.request
    }, 
    function(error, response, body) {
      if (error) {
        sails.log.error(error);
        throw 'apiFailed';
      }
      else {
        sails.log.info(response);
        sails.log.info(body);
        return exits.success(body);
      }
    });
  }

};