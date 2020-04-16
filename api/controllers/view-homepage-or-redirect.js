module.exports = {


  friendlyName: 'View homepage or redirect',


  description: 'Display or redirect to the appropriate homepage, depending on login status.',


  exits: {

    success: {
      responseType: 'view',
      statusCode: 200,
      description: 'Requesting user is a guest, so show the public landing page.',
      viewTemplatePath: 'pages/homepage'
    },

    redirect: {
      responseType: 'redirect',
      description: 'Requesting user is logged in, so redirect to the internal welcome page.'
    },

  },


  fn: async function () {
    var nestedPop = require('nested-pop');
    var entityList = await Dispositif.find().populate('positions',{sort: 'timestamp DESC'}).then(
      function(dispositifs) {
        return nestedPop(dispositifs, {
            positions: {
                as: 'position',
                populate: [
                    'beacon'
                ]
            } 
        }).then(function(dispositifs) {
            return dispositifs
        }).catch(function(err) {
            throw err;
      });
    }).catch(function(err) {
      throw err;
    });
      return  {
        apiEntityList : entityList
      };
  }


};
