module club(){
	for(i = [0: .01: 1.38]){
		translate([0, 0, i])
		cylinder(r = sqrt(.5625 - (pow(i - .75, 2))), h = .01, $fs = .1);
	}
	for(i = [1.38: .01: 9.3]){
		translate([0, 0, i])
		cylinder(r = .032*(i - 1.38)+.41, h = .01, $fs = .1);
	}
	for(i = [9.3: .01: 11]){
		translate([0, 0, i])
		cylinder(r = pow(1.2, i - 11.11) - .059, h = .01, $fs = .1);
	}
	for(i = [11: .01: 21]){
		translate([0, 0, i])
		cylinder(r = -.03 * pow(i - 16, 2) + 1.67, h = .01, $fs = .1);
	}
}

module hollow(){
	for(i = [.4: .01: 1.38]){
		translate([0, 0, i])
		cylinder(r = -.9*(pow(i-.75,2)) + .604, h = .01, $fs = .1);
	}
	for(i = [1.38: .01: 9.3]){
		translate([0, 0, i])
		cylinder(r = .027*(i - 1.5) + .25, h = .01, $fs = .1);
	}
	for(i = [9.3: .01: 11]){
		translate([0, 0, i])
		cylinder(r = .222*i - 1.603, h = .01, $fs = .1);
	}
	for(i = [11: .01: 20.92]){
		translate([0, 0, i])
		cylinder(r = -.03 * pow(i - 16, 2) + 1.59, h = .01, $fs = .1);
	}
}

module onlyShowPart(x){
	if(x == 1){
		translate([-10, -10, 5.25]) cube(20);
	}
	if(x == 2){
		translate([-2.625, -2.625, 0]) cube(5.25);
		translate([-10, -10, 10.5]) cube(20);
	}
	if(x == 3){
		translate([-5.25, -5.25, 0]) cube(10.5);
		translate([-3, -3, 15.75]) cube(6);
	}
	if(x == 4){
		translate([-7.875, -7.875]) cube(15.75);
	}
}

difference(){
	club();
	%hollow();
	%onlyShowPart(3);
}


