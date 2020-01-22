/**
 * User.js
 *
 * A user who can log in to this application.
 */

module.exports = {

  attributes: {

    //  ╔═╗╦═╗╦╔╦╗╦╔╦╗╦╦  ╦╔═╗╔═╗
    //  ╠═╝╠╦╝║║║║║ ║ ║╚╗╔╝║╣ ╚═╗
    //  ╩  ╩╚═╩╩ ╩╩ ╩ ╩ ╚╝ ╚═╝╚═╝

    entityId: {
      type: 'integer',
      required: true,
      unique: true
    },
    entityDisplayName: {
      type: 'string',
      required: true,
      unique: true
    },
    entityFullName: {
      type: 'string',
      required: true,
      unique: true
    },
    entityMacAddress: {
      type: 'string',
      required: true,
      unique: true
    },
    entityRegistered: {
      type: 'boolean',
      required: true,
    }
  },


};
