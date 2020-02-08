module.exports = {


  friendlyName: 'Request database',

   inputs: {
      request: {
        description: 'The request to look for.',
        type: 'string',
        required: true
      },
      parameters: {
        description: 'The parameters to add.',
        type: 'json',
        required: false
      }
   },
  exits: {

    success: {
      responseType: '',
      statusCode: 200,
      description: 'Requesting user is a guest, so show the public landing page.',
    },
    apiFailed: {
      responseType: '',
      statusCode: 500,
      description: 'API Call failed',
    },

  },


  fn: async function (inputs,exists) {
    var data = await sails.helpers.apiQuery("/"+inputs.request,inputs.parameters).intercept('apiFailed', (err)=>{
      return 'apiFailed';
    });
    return data;
  }


};
