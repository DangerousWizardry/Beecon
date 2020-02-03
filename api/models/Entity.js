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

  generateDummyValue : async function(opts){
    var entity = await Entity.find();
    console.log("Entity find"+JSON.stringify(entity));
    if (!entity) {
      entity = await Entity.createEach([{
        entityId:1,
        entityDisplayName:"Docteur 1",
        entityFullName:"Docteur X - M. John",
        entityMacAddress:"134:21:88F3:FF::152:956:23B",
        entityRegistered:true
      },
      {
        entityId:2,
        entityDisplayName:"Docteur 2",
        entityFullName:"Docteur X - M. John",
        entityMacAddress:"134:21:88F3:FF::152:956:24B",
        entityRegistered:true
      },
      {
        entityId:3,
        entityDisplayName:"Docteur 3",
        entityFullName:"Docteur X - M. John",
        entityMacAddress:"134:21:88F3:FF::152:956:25B",
        entityRegistered:true
      },
      {
        entityId:4,
        entityDisplayName:"Docteur 4",
        entityFullName:"Docteur X - M. John",
        entityMacAddress:"134:21:88F3:FF::152:956:26B",
        entityRegistered:true
      }]).fetch();
      console.log("Entity fetch"+entity);
    }
    else{
      return entity;
    }
  }


};
