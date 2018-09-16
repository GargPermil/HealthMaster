var express = require('express');
var router = express.Router();
//MySQL
const mysql = require('mysql');
const con = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '0000',
  database: 'healthmaster'
});
try {
con.connect((err) => {
  //if (err) throw err;
  console.log('Connected My SQL!');
});
} catch(err)
{
    console.log("exception" + err)
}

con.on('error', function() {
    console.log("connection error");
});

//to get the tips of games
router.get("/tips",function(req,res){
    try
    {
        con.query("SELECT * from tbl_tips",function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                //console.log(row);
                res.send(row);
            }
        });
    }catch(err)
    {
        console.log("exception handled" + err);
    }

});
//to get the tips of games ends here

//to get deatils of player
router.get("/playerDetails",function(req,res){
    try{
        var pid = 1;
        var data = [pid];
        con.query("SELECT * from avatar where pid = ?",data, function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
               // console.log(row);
                res.send(row);
            }
        })
    }catch(err)
    {
        console.log("exception" + err);
    }
});
//player deatils ends here

//list of foods
router.get("/foods",function(req,res){
    try{
        con.query("SELECT * FROM tbl_food",function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
             //   console.log(row);
                res.send(row);
            }
        })
    }catch(err)
    {
        console.log("exception" + err);
    }
});
//list of foods ends here

//list of inventory
router.get("/inventory",function(req,res){
    try{
        var pid = 1;
        var data = [pid];
        con.query("SELECT * FROM tbl_inventory where player_id = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
    }catch(err)
    {
        //console.log("exception" + err);
        res.send(row);
    }
});
//list of inventory ends here

//list of market values
router.get("/marketDetails",function(req,res){
   try
   {
        con.query("SELECT mid,foodid,sellprice,sellerid, tbl_food.name FROM tbl_market INNER JOIN tbl_food on tbl_market.foodid=tbl_food.fid;",function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
   } catch (err) {
       console.log("exception" + err);
   }
});
//list of market values ends here

//player muscle details
router.get("/muscleDetails",function(req,res){
    try{
        var playerId = 1;
        var data = [playerId];
        con.query("SELECT * FROM tbl_muscless WHERE pid = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
    }catch (err) {
       console.log("exception" + err);
   }
});
//player muscle details ends here

//quiz questions
router.get("/Quiz",function(req,res){
    try{
        var ques = 1;
        var data = [ques];
        con.query("SELECT * FROM tbl_quiz WHERE qid = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
    }catch (err) {
       console.log("exception" + err);
   }
});
//quiz questions ends here

//stats details
router.get("/stats",function(req,res){
    try{
        var pid = 1;
        var data = [pid];
        con.query("SELECT * FROM tbl_stats WHERE playerId = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
    }catch (err) {
       console.log("exception" + err);
   }
});
//stats details ends here

//vocab questions
router.get("/vocab",function(req,res){
    try{
        var ques = 1;
        var data = [ques];
        con.query("SELECT * FROM tbl_vocab WHERE vid = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                res.send(row);
            }
        })
    }catch (err) {
       console.log("exception" + err);
   }
});
//vocab questions ends here

//player data updtae on the basis of quiz
router.get("/completeQuiz",function(req,res){
    try
    {
        var quizData = 5;
        var player_id = 1;
        var data = [player_id];
        con.query("UPDATE avatar set lvlexperience = lvlexperience + 5,gold = gold + 5 WHERE pid = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                console.log("update done");
                res.send("successful");
            }
        })
    }catch(err)
    {
        console.log("exception" + err);
    }
    finally{console.log("exception handled");}
   

});
//player data updtae on the basis of quiz ends here

//player data updtae on the basis of vocab
router.get("/completeVocab",function(req,res){
    try
    {
        var vocabData = 5;
        var player_id = 1;
        var data = [player_id];
        con.query("UPDATE avatar set lvlexperience = lvlexperience + 5,gold = gold + 5 WHERE pid = ?",data,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                console.log("update done");
                res.send("successfully update");
            }
        })
    }catch(err)
    {
        console.log("exception" + err);
    }
    

});
//player data updtae on the basis of vocab ends here

//update muscle
router.get("/muscleupdate",function(req,res){
    try{
        var player_id = 1;
        var type = 'chest';
        var data = [player_id];
        if(type == 'forearms')
        {
            con.query("UPDATE tbl_muscle SET forearms = forearms + 1 WHERE pid = ? ",data,function(err,row){
                if(err)
                {
                    throw err;
                }
                else
                {
                    res.send("forearms update");
                }
            })
        }
        else if(type == 'chest')
        {
            con.query("UPDATE tbl_muscle SET chest = chest + 1 WHERE pid = ? ",data,function(err,row){
                if(err)
                {
                    throw err;
                }
                else
                {
                    res.send("chest update");
                }
            })
        }
    }catch(err)
    {
        console.log("exception" + err);
    }
});
//update muscle ends here

//status update
router.get("/status",function(req,res){
    try
    {
        var player_id = 1;
        var gameid = 1;
        var lastscore = 20;
        var highestscore;
        var fetch = [player_id,gameid];
        con.query("SELECT highestScore FROM tbl_stats WHERE playerId = ? AND gameid = ?",fetch,function(err,row){
            if(err)
            {
                throw err;
            }
            else
            {
                if(lastscore < row[0].highestScore)
                {
                    highestscore = row[0].highestScore;
                }
                else
                {
                     highestscore = lastscore;
                }
                var type = 1;
                if(gameid == 1)
                {
                    gamename = 'quiz';
                }
                else if(gameid == 2)
                {
                    gamename = 'vocab';
                }
                var data = [lastscore,highestscore,player_id,gameid];
                con.query("UPDATE tbl_stats set lastscore = ?, highestScore = ?, totalPlayed = totalPlayed+1 where playerId = ? AND gameid = ?",data, function(err, row) {
                    if(err)
                    {
                        throw err;
                    }
                    else
                    {
                        res.send("updated");
                    }
                });
            }
        });
    } catch(err) {
        console.log("error in updating stats" + err);
    }
});
//status update ends here

module.exports = router;