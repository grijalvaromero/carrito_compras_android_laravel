<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class FavsMigration extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('favs', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('id_user')->unsigned();//de qué usuario es
            $table->integer('id_product')->unsigned();//de qué producto es

            $table->timestamps();

            //Relaciones
            $table->foreign('id_product')->references('id')->on('products');
            $table->foreign('id_user')->references('id')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('favs');
    }
}
