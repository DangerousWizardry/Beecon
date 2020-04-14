/**
 * Beacon.js
 *
 * A beacon
 */

module.exports = {

  attributes: {

    //  ╔═╗╦═╗╦╔╦╗╦╔╦╗╦╦  ╦╔═╗╔═╗
    //  ╠═╝╠╦╝║║║║║ ║ ║╚╗╔╝║╣ ╚═╗
    //  ╩  ╩╚═╩╩ ╩╩ ╩ ╩ ╚╝ ╚═╝╚═╝
    id: {
      type: 'number',
      required: true,
      unique: true
    },
    addMac: {
      type: 'string',
      required: true
    },
    xEmplacement: {
      type: 'number',
      required: true
    },
    yEmplacement: {
      type: 'number',
      required: true
    },
    nom:{
      type: 'string',
      required: true
    }
  },


};
