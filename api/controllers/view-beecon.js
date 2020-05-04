module.exports = {


  friendlyName: 'View Beecon page',


  description: 'Display the beecon page',


  exits: {

    success: {
      responseType: 'view',
      statusCode: 200,
      description: 'Requesting user is a guest, so show the public landing page.',
      viewTemplatePath: 'pages/beecon'
    }

  },


  fn: async function () {

  }


};
