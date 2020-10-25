function countDown() {
    var val = [1,2,3,4,5];
    var sum = 0;
    for(var i = 0; i < val.length; i++){
        sum += val[i];
    }
    console.log(sum);
}

//countDown();
var val = [true, true, true, true, true];
console.log(typeof val);
console.log(val.length);
val.map((idx)=>console.log(idx));