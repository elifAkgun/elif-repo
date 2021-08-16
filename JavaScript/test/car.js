var Car = function() {
    var wheels = 4,
      fuel = 16; 
    this.color;
    this.getWheels = function() {
      return wheels;
    }
    this.getFuel = function() {
      return fuel;
    }
    this.getColor = function() {
      if (!this.color) {
        throw new Error("Color has not been set yet");
      }
      return this.color;  
    }
    this.setColor = function(color) {
      if (['Red', 'Green', 'Blue'].indexOf(color) >= 0) {
        this.color = color;
      }
      else {                                                                                                                   
        throw new Error("I am very picky about my car colors." +
          "Please pass in either Red, Green or Blue");
      }
    }
  };
  //Create a new Car instance
  var car = new Car();

  Car.prototype.moveForward = function(distance) {                                                                             
    console.log("Move car by " + distance);
  };
  
  Car.prototype.stayPut = function() { console.log("I do not have enought fuel to move"); };
  
  Car.prototype.hasEnoughFuel = function(fuel, distance) { var deferred = $.Deferred(); $.ajax({ url: "/check_forward_movement_ability.json", type: "GET", }) .done(function(response) { deferred.resolve(response.canMove); }).fail(function(response) { deferred.fail(); }); return deferred.promise(); };
  
  Car.prototype.driveForward = function(distance) { var promise = this.hasEnoughFuel(this.fuel, distance); var self = this; $.when(promise).done(function(canMove) { if (canMove) self.moveForward(distance); else self.stayPut(distance); }); };