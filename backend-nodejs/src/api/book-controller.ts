import express, {json} from "express";
import mysql, {Pool} from "promise-mysql";
import dotenv from 'dotenv';

export const router = express.Router();

let pool:Pool;
dotenv.config();

(async ()=>{
    pool =  await mysql.createPool({
        host: process.env.host,
        port: +process.env.port!,
        database: process.env.database,
        user: process.env.username,
        password: process.env.password,
        connectionLimit: +process.env.connection_limit!,
    });
})();

type Book ={
    isbn:string,
    title:string
}

/* Delete existing book*/
router.delete("/:isbn", async (req, res)=>{
    console.log(req.params.isbn);
   const result = await pool.query("DELETE FROM book WHERE isbn=?", [req.params.isbn]);
    res.sendStatus(result.affectedRows ? 204 : 404);
});

/* Update the book title*/
router.patch("/:isbn", async (req, res)=>{
   const book = req.body as Book;
   book.isbn = req.params.isbn;
   if(!book.title){
       res.sendStatus(400);
       return;
   }

    const result = await pool.query("UPDATE book set title=? WHERE isbn=?", [book.title, book.isbn]);
    res.sendStatus(result.affectedRows ? 204 : 404);

});