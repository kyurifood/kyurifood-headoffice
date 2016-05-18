package com.artivisi.android.kyurifood.headoffice.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.artivisi.android.kyurifood.headoffice.R;
import com.artivisi.android.kyurifood.headoffice.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DistributorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DistributorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DistributorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText txtkode, txtnama, txthp, txtalamat, txtkodepos, txtemail, txtpas, txtcpas;
    Button btn_bank;
    Dialog addBank;
    EditText txtrek,txtpemilik,txtcabang;
    Spinner spinnerbank;

    public DistributorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DistributorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DistributorFragment newInstance(String param1, String param2) {
        DistributorFragment fragment = new DistributorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_distributor, container, false);
        txtkode = (EditText)view.findViewById(R.id.editkode);
        if (txtkode.getText().toString().length() == 0){
            txtkode.setError("anjrit");
        }


        btn_bank = (Button) view.findViewById(R.id.btnbank);
        btn_bank.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                showAddBank();
            }

            private void showAddBank() {
                addBank = new Dialog(getActivity());
                addBank.setContentView(R.layout.bank_distributor);
                addBank.setTitle("Add Bank");
                addBank.setCancelable(false);
                addBank.show();

                final Spinner mSpinner= (Spinner)view.findViewById(R.id.spinnerbank);
                txtrek = (EditText) view.findViewById(R.id.editText);
                txtpemilik = (EditText) view.findViewById(R.id.editText2);
                txtcabang = (EditText) view.findViewById(R.id.editText3);
                spinnerbank = (Spinner) view.findViewById(R.id.spinnerbank);

                Button but = (Button) addBank.findViewById(R.id.cancel);
                but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addBank.dismiss();
                    }
                });
                Button ok = (Button) addBank.findViewById(R.id.ok);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addBank.dismiss();
                    }
                });




            }




        });

        return view;
    }




        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
