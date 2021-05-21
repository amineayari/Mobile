///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.myapp;
//
///**
// *
// * @author House_Info
// */
//public class deleteVoyage(NormalizerInterface $Normalizer, $id, Request $request): Response
//    {
//        $repository = $this->getdoctrine()->getRepository(OffreStage :: class);
//        $OffreStage = $repository->find($id);
//
//        $em = $this->getDoctrine()->getManager();
//        $em->remove($OffreStage);
//        $em->flush();
//
//        $jsonContent = $Normalizer->normalize($OffreStage, 'json', ['groups' => 'post:read']);
//        return new Response("User deleted" . json_encode($jsonContent));
//    }