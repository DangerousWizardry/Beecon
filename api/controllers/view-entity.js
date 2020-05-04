module.exports = {


  friendlyName: 'View entity',


  description: 'Display entity page',


  exits: {

    success: {
      responseType: 'view',
      statusCode: 200,
      viewTemplatePath: 'pages/entity'
    }

  },


  fn: async function () {
    return {knownEntities : await Dispositif.find({entityRegistered:true}),unknownEntities : await Dispositif.find({entityRegistered:false})};
  }
};
