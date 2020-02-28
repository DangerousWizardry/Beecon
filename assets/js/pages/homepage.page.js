parasails.registerPage('homepage', {
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝

  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function() {
    // Attach any initial data from the server.
    _.extend(this, SAILS_LOCALS);

  },
  mounted: async function(){
    this._initMap();
  },

  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {
    clickEntity: async function() {
      io.socket.on('http://localhost:9092', function gotHelloMessage (data) {
        console.log('User alert!', data);
      });
        io.socket.get('http://localhost:9092', function gotResponse(data, jwRes) {
          console.log('Server responded with status code ' + jwRes.statusCode + ' and data: ', data);
        });
      var data = await $.get("/api?request=dispositifs");
      /*.then((data) =>    {
        document.getElementById('entity-info-data').innerHTML = data;
        console.log(data);
      });*/
      
    },
    _initMap: function(){
      var pixiRoot = new PIXI.Application($("body").width()/2, 400, { backgroundColor : 0x6BACDE });
      ////// Here, we create our traviso instance and add on top of pixi
      document.getElementById('map-container').appendChild(pixiRoot.view);
      console.log(pixiRoot.view);
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
