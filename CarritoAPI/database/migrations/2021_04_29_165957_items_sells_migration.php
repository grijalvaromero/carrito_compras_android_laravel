<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class ItemsSellsMigration extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('items_sells', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('id_sell')->unsigned();
            $table->integer('id_product')->unsigned();
            $table->double('quantity');
            $table->double('price');
            $table->double('total');
            $table->timestamps();

            //Relaciones
            $table->foreign('id_sell')->references('id')->on('sells');
            $table->foreign('id_product')->references('id')->on('products');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('items_sells');
    }
}
