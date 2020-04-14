/**
 * <ajax-button>
 * -----------------------------------------------------------------------------
 * A button with a built-in loading spinner.
 *
 * @type {Component}
 *
 * @event click   [emitted when clicked]
 * -----------------------------------------------------------------------------
 */

parasails.registerComponent('entity-info', {

   data: function(){
     return {lastReceived: null, beaconsHtml : ''}
   },
  //  ╔═╗╦═╗╔═╗╔═╗╔═╗
  //  ╠═╝╠╦╝║ ║╠═╝╚═╗
  //  ╩  ╩╚═╚═╝╩  ╚═╝
   props:
   {
     entityDisplayName : String,
     entityId: Number,
     entityFullName : String,
     entityMacAddress : String,
     positions: Array,
     entityRegistered: Boolean
   },

   watch:{
      entityId:{
        immediate: true, 
        handler(val) {
          this.scanAttributes();
        }
      }
   },
  //  ╦╔╗╔╦╔╦╗╦╔═╗╦    ╔═╗╔╦╗╔═╗╔╦╗╔═╗
  //  ║║║║║ ║ ║╠═╣║    ╚═╗ ║ ╠═╣ ║ ║╣
  //  ╩╝╚╝╩ ╩ ╩╩ ╩╩═╝  ╚═╝ ╩ ╩ ╩ ╩ ╚═╝
    template: `
    <div class="row">
      <div class="col1">
        <div class="label"><b>Entity Name</b><b>Entity Id</b><b>Full Name</b><b>Mac Adress</b></div>
        <div class="value">
          <span>{{entityDisplayName}}</span>
          <span>{{entityId}}</span>
          <span>{{entityFullName}}</span>
          <span>{{entityMacAddress}}</span>
        </div>
      </div>
      <div class="col2">
        <div class="last-received"><b>Dernière Réception:</b> {{lastReceived }}</div>
        <div class="beacons">
          Beacons les plus proches
          <div class="beacon-grid" v-html="beaconsHtml">
          </div>
        </div>
      </div>
    </div>`,
  //
  //  ╦  ╦╔═╗╔═╗╔═╗╦ ╦╔═╗╦  ╔═╗
  //  ║  ║╠╣ ║╣ ║  ╚╦╝║  ║  ║╣
  //  ╩═╝╩╚  ╚═╝╚═╝ ╩ ╚═╝╩═╝╚═╝
  beforeMount: function() {
    //…
  },
  mounted: async function(){
    //Keep entity-info up-to-date
  },
  beforeDestroy: function() {
    //…
  },

  //  ╦╔╗╔╔╦╗╔═╗╦═╗╔═╗╔═╗╔╦╗╦╔═╗╔╗╔╔═╗
  //  ║║║║ ║ ║╣ ╠╦╝╠═╣║   ║ ║║ ║║║║╚═╗
  //  ╩╝╚╝ ╩ ╚═╝╩╚═╩ ╩╚═╝ ╩ ╩╚═╝╝╚╝╚═╝
  methods: {
    scanAttributes:function(){
      console.log(typeof this.positions != 'undefined');
      if (typeof this.positions != 'undefined') {
        this.lastReceived = new Date(this.positions[0].timestamp).toLocaleString("fr-FR");
        var positions = this.positions;
        let reliablePosition = this.positions.filter( position => {
          return positions[0].timestamp-10000 < position.timestamp
        });
        console.log(reliablePosition);
        this.beaconsHtml = '';
        for(position of reliablePosition){
          this.beaconsHtml += '<span>'+position.beacon.nom+'</span><img src="/images/network/network-'+ this._evalSignalStrength(position.attenuation) +'.png">';
        }
      }
    },
    _evalSignalStrength:function(signal){
       if(signal<25){
         return 4;
       }
       else if(signal>=25 && signal<40){
         return 3;
       }
       else if(signal>=40 && signal<70){
         return 2;
       }
       else{
         return 1;
       }
    }
  }
});
