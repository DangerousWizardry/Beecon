/**
 * Dispositif.js
 *
 * An entity who navigate throught the map
 */

module.exports = {

  attributes: {

    //  ╔═╗╦═╗╦╔╦╗╦╔╦╗╦╦  ╦╔═╗╔═╗
    //  ╠═╝╠╦╝║║║║║ ║ ║╚╗╔╝║╣ ╚═╗
    //  ╩  ╩╚═╩╩ ╩╩ ╩ ╩ ╚╝ ╚═╝╚═╝

    entityId: {
      type: 'number',
      required: true,
      unique: true
    },
    entityDisplayName: {
      type: 'string',
      required: true
    },
    entityFullName: {
      type: 'string',
      required: true
    },
    entityMacAddress: {
      type: 'string',
      required: true
    },
    entityRegistered: {
      type: 'boolean',
      required: true
    },
    positions:{
      collection: 'position',
      via: 'owner'
    }
  },



};
/*

*/