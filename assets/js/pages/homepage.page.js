var entityInfoComponent = {
  props:['selectedEntity'],
  template: '<div class="row"><div class="col1"><div class="label"><b>Entity Name</b><b>Entity Id</b><b>Full Name</b><b>Mac Adress</b></div><div class="value"><span>{{selectedEntity.entityDisplayName}}</span><span>{{selectedEntity.entityId}}</span><span>{{selectedEntity.entityFullName}}</span><span>{{selectedEntity.entityMacAddress}}</span></div></div><div class="col2"><div class="last-received">{{ new Date(selectedEntity.positions[selectedEntity.positions.length -1].timestamp) }}</div><div class="progress"></div></div></div>'
};
parasails.registerPage('homepage', {
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝
  data : {
    entities:[],
    selectedEntity:new Array()
  },
  components : {
    'entity-info' : entityInfoComponent
  },
  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function() {
    // Attach any initial data from the server.
    _.extend(this, SAILS_LOCALS);
    this.entities = this.apiEntityList;
    console.log(this.selectedEntity);
  },
  mounted: async function(){
    this._initMap();
    var _myVue = this; 
    io.socket.on('positionUpdated', function onServerSentEvent (msg) {
      _myVue.entities = msg;
    });
    function _keepWatchesOnTime(){
      console.log("o'clock !");
        _myVue.entities[0].positions[_myVue.entities[0].positions.length-1].timestamp = _myVue.entities[0].positions[_myVue.entities[0].positions.length -1].timestamp+1;
    }
    setInterval(_keepWatchesOnTime,5000);
  },
  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {

    clickEntity: function(entity) {
      this.selectedEntity = entity;
      console.log(this.selectedEntity);

    },
    renderDurationName: function(timestamp) {
      var timeout = + new Date()-new Date(timestamp);
       if(timeout<10000){
         return "Il y a quelques secondes";
       }
       else if(timeout>=10000 && timeout<60000){
         return "Il y a "+ Math.floor(timeout/1000)+ " secondes";
       }
       else if(timeout>=60000 && timeout<3600000){
         return "Il y a "+ Math.floor(timeout/60000)+ " minutes";
       }
       else{
         return "Il y a plus d'une heure";
       }
     },
     renderSignal: function(timestamp) {
      var timeout = + new Date()-new Date(timestamp);
       if(timeout<20000){
         return "green";
       }
       else if(timeout>=20000 && timeout<60000){
         return "orange";
       }
       else if(timeout>=60000 && timeout<3600000){
         return "red";
       }
       else{
         return "gray";
       }
     },
    _initMap: function(){
      var pixiRoot = new PIXI.Application($("body").width()/2, 400, { backgroundColor : 0x6BACDE });
      ////// Here, we create our traviso instance and add on top of pixi
      document.getElementById('map-container').appendChild(pixiRoot.view);
      // engine-instance configuration object
      var instanceConfig = {
          mapDataPath: "/example1/mapData.json", // the path to the json file that defines map data, required
          assetsToLoad: ["/assets/assets_map.json", "/assets/assets_characters.json"] // array of paths to the assets that are desired to be loaded by traviso, no need to use if assets are already loaded to PIXI cache, default null
      };

      var engine = TRAVISO.getEngineInstance(instanceConfig);
      pixiRoot.stage.addChild(engine);
    }
  }
});
